@echo off
setlocal enabledelayedexpansion

set "CD=%~dp0"
set "CD=%CD:~0,-1%"

echo %1 | findstr /r "\.java *$" >nul 2>&1
if errorlevel 1 (
  echo Usage:
  echo   %~nx0 ^<filename^>.java
  exit /b 1
)



goto :replace_class_name_end

:replace_class_name
set "INFILE=%~1"
set "OUTFILE=%~2"
set "CLASSNAME_FROM=%~3"
set "CLASSNAME_TO=%~4"

set "TEMP=%TEMP%\%RANDOM%.tmp"

rem первая замена: class NAME -> class NAME_jbc
(
  for /f "usebackq delims=" %%L in ("%INFILE%") do (
    set "line=%%L"
    set "line=!line:class %CLASSNAME_FROM%=class %CLASSNAME_TO%!"
    echo(!line!
  )
) > "%TEMP%"

rem вторая замена: new NAME -> new NAME_jbc
(for /f "usebackq delims=" %%L in ("%TEMP%") do (
    set "line=%%L"
    set "line=!line:new %CLASSNAME_FROM%=new %CLASSNAME_TO%!"
    echo(!line!)
) > "%OUTFILE%"

del "%TEMP%"

exit /b

:replace_class_name_end



set "FILENAME=%~dpn1"
set "CLASSNAME=%~n1"

del /f /q "%FILENAME%.class" "%FILENAME%_jbc.class" "%FILENAME%.jbc" "%FILENAME%_jbc.jbc" >nul 2>&1
rd /s /q "%FILENAME%_tmp" >nul 2>&1

call "%CD%\javac" --release 17 "%FILENAME%.java"
call "%CD%\proguard-assembler" "%FILENAME%.class" "%FILENAME%.jbc"
call :replace_class_name "%FILENAME%.jbc" "%FILENAME%_jbc.jbc" "%CLASSNAME%" "%CLASSNAME%_jbc"
call "%CD%\proguard-assembler" "%FILENAME%_jbc.jbc" "%FILENAME%_jbc.class"
call "%CD%\proguard" -dontwarn -dontoptimize -dontobfuscate -dontshrink -injars "%FILENAME%_jbc.class" -outjars "%FILENAME%_tmp"
copy /y "%FILENAME%_tmp\%CLASSNAME%_jbc.class" "%FILENAME%_jbc.class"  >nul 2>&1
rd /s /q "%FILENAME%_tmp" >nul 2>&1

del /f /q "%FILENAME%_jbc.jbc" >nul 2>&1
