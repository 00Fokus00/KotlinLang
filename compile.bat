@echo off

set "CD=%~dp0"
set "CD=%CD:~0,-1%"

set "RUNTIME_JAVA=%CD%\src\main\java"

if exist "%CD%\bin\_props.bat" call "%CD%\bin\_props.bat"
if exist "%CD%\_props.bat"     call "%CD%\_props.bat"


set "FILENAME=%~dpn1"
if "%~1"=="" (
  (
    echo Usage:
    echo   %~nx0 source.kt
  ) 1>&2
  exit 1
)
if not exist "%~1" (
  (
    echo File "%~1" not exists
  ) 1>&2
  exit 2
)

set "DIR=%~dp1"
set "DIR=%DIR:~0,-1%"

del /f /q "%DIR%\*.jbc" "%FILENAME%.class" "%FILENAME%.jar" >nul 2>&1

rem Step 1 .kt -> .jbc
java -jar "%CD%\DemoLang.jar" "%~dpnx1"
set STATUS=%ERRORLEVEL%
if not "%STATUS%"=="0" exit /b %STATUS%

rem Find the .jbc file that was just created in DIR
set CLASSNAME=
for %%F in ("%DIR%\*.jbc") do set CLASSNAME=%%~nF
if "%CLASSNAME%"=="" (
  echo [ERROR] .jbc file not found in %DIR%
  exit /b 3
)

rem Step 2 .jbc -> .class
call "%CD%\bin\proguard-assembler" "%DIR%\%CLASSNAME%.jbc" "%DIR%\%CLASSNAME%.class"

rem Step 3
call "%CD%\bin\proguard" -dontwarn -dontoptimize -dontobfuscate -dontshrink "-injars" "%DIR%\%CLASSNAME%.class" "-outjars" "%DIR%\%CLASSNAME%_tmp"
copy /y "%DIR%\%CLASSNAME%_tmp\%CLASSNAME%.class" "%DIR%\%CLASSNAME%.class" >nul 2>&1
rd /s /q "%DIR%\%CLASSNAME%_tmp" >nul 2>&1

rem Step 4 .class + Runtime.class -> .jar
call "%CD%\bin\jar" --create --file "%FILENAME%.jar" --main-class "%CLASSNAME%" -C "%DIR%" "%CLASSNAME%.class" -C "%RUNTIME_JAVA%" ru\vsu\cs\demolang\runtime\Runtime.class

echo.
echo Ready: %FILENAME%.jar