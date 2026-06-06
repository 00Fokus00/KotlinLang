@echo off
setlocal enabledelayedexpansion

set "CD=%~dp0"
set "CD=%CD:~0,-1%"

set DOTNET_SDKS_DIR=C:\Program Files\dotnet\sdk
set DOTNET_VERSION=10.0
set NUGET_PACKAGES=%USERPROFILE%\.nuget\packages

if exist "%CD%\_props.bat" call "%CD%\_props.bat"


set ILDASM=
for /f "delims=" %%F in ('dir /s /b "%NUGET_PACKAGES%\runtime.win-x64.microsoft.netcore.ildasm"\ildasm.exe') do (
  set ILDASM="%%F"
)

if exist "%CD%\_props.bat" call "%CD%\_props.bat"


set OUT_FILE=
for %%A in (%*) do (
  echo %%~A | findstr /i "^[-/]out" >nul 2>&1
  if not errorlevel 1 (
    for /f "tokens=1,* delims=:=" %%B in ("%%~A") do set OUT_FILE=%%~C
  )
)

for %%S in ("%OUT_FILE%") do set OUT_FILE_WITHOUT_EXT=%%~dpnS


%ILDASM% %*

del /f /q "%OUT_FILE_WITHOUT_EXT%.res" >nul 2>&1
