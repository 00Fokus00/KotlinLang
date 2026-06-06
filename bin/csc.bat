@echo off
setlocal enabledelayedexpansion

set "CD=%~dp0"
set "CD=%CD:~0,-1%"

set DOTNET_SDKS_DIR=C:\Program Files\dotnet\sdk
set DOTNET_VERSION=10.0
set NUGET_PACKAGES=%USERPROFILE%\.nuget\packages

if exist "%CD%\_props.bat" call "%CD%\_props.bat"


set CSC=
for /f "delims=" %%D in ('dir /b "%DOTNET_SDKS_DIR:"=%"\%DOTNET_VERSION%.*') do (
  set DOTNET_SDK_DIR=%DOTNET_SDKS_DIR:"=%\%%D
  set CSC=
  for /f "delims=" %%F in ('dir /s /b "!DOTNET_SDK_DIR!"\csc.exe') do (
    set CSC="%%F"
  )
)

set REFERENCES=mscorlib.dll netstandard.dll
set RR=
for %%R in (%REFERENCES%) do (
  for /f "delims=" %%F in ('dir /s /b "!DOTNET_SDK_DIR!"\ref\%%R') do (
    if defined RR (
      set RR=!RR!,%%F
    ) else (
      set RR=%%F
    )
  )
)
if defined RR set CSC=%CSC% -reference:"%RR%"

if exist "%CD%\_props.bat" call "%CD%\_props.bat"


set CS_FILE=
set OUT_FILE=
for %%A in (%*) do (
  echo %%~A | findstr /i "\.cs *$" >nul 2>&1
  if not errorlevel 1 set CS_FILE=%%~A

  echo %%~A | findstr /i "^[-/]out" >nul 2>&1
  if not errorlevel 1 (
    for /f "tokens=1,* delims=:=" %%B in ("%%~A") do set OUT_FILE=%%~C
  )
)
if defined CS_FILE (
  if not defined OUT_FILE (
    for %%S in ("%CS_FILE%") do set OUT_FILE=.\%%~nS.exe
  )
)

rem if exist "%CS_FILE%" if exist "%OUT_FILE%" (
rem   del /f "%OUT_FILE%"
rem )

for %%S in ("%OUT_FILE%") do set OUT_FILE_WITHOUT_EXT=%%~dpnS


%CSC% %*


if exist "%CS_FILE%" if exist "%OUT_FILE%" (
  (
    echo {
    echo   "runtimeOptions": {
    echo     "framework": {
    echo        "name": "Microsoft.NETCore.App",
    echo        "version": "%DOTNET_VERSION%.0"
    echo     }
    echo   }
    echo }
  ) >"%OUT_FILE_WITHOUT_EXT%.runtimeconfig.json"
)
