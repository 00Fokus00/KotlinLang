@echo off
setlocal enabledelayedexpansion

set "CD=%~dp0"
set "CD=%CD:~0,-1%"

set DOTNET_SDKS_DIR=C:\Program Files\dotnet\sdk
set DOTNET_VERSION=10.0
set NUGET_PACKAGES=%USERPROFILE%\.nuget\packages

if exist "%CD%\_props.bat" call "%CD%\_props.bat"


set ILASM=
for /f "delims=" %%F in ('dir /s /b "%NUGET_PACKAGES%\runtime.win-x64.microsoft.netcore.ilasm"\ilasm.exe') do (
  set ILASM="%%F"
)

if exist "%CD%\_props.bat" call "%CD%\_props.bat"


set IL_FILE=
set OUT_FILE=
for %%A in (%*) do (
  echo %%~A | findstr /i "\.il *$" >nul 2>&1
  if not errorlevel 1 set IL_FILE=%%~A

  echo %%~A | findstr /i "^[-/]out" >nul 2>&1
  if not errorlevel 1 (
    for /f "tokens=1,* delims=:=" %%B in ("%%~A") do set OUT_FILE=%%~C
  )
)
if defined IL_FILE (
  if not defined OUT_FILE (
    for %%S in ("%IL_FILE%") do set OUT_FILE=.\%%~nS.exe
  )
)

for %%S in ("%OUT_FILE%") do set OUT_FILE_WITHOUT_EXT=%%~dpnS


%ILASM% %*


if exist "%IL_FILE%" if exist "%OUT_FILE%" (
  (
    echo {
    echo   "runtimeOptions": {
    echo     "framework": {
    echo       "name": "Microsoft.NETCore.App",
    echo       "version": "10.0.0"
    echo     }
    echo   }
    echo }
  ) >"%OUT_FILE_WITHOUT_EXT%.runtimeconfig.json"
)
