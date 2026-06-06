@echo off
setlocal enabledelayedexpansion

set "CD=%~dp0"
set "CD=%CD:~0,-1%"

echo %1 | findstr /r "\.cs *$" >nul 2>&1
if errorlevel 1 (
  echo Usage:
  echo   %~nx0 ^<filename^>.cs
  exit /b 1
)



set "FILENAME=%~dpn1"

del /f /q "%FILENAME%.exe" "%FILENAME%.il.exe" "%FILENAME%.il.res" "%FILENAME%.res" "%FILENAME%.pdb" "%FILENAME%.exe.mdb" "%FILENAME%.il" "%FILENAME%.il.html" "%FILENAME%.il.runtimeconfig.json" >nul 2>&1

call "%CD%\csc" -optimize+ -debug+ -out:"%FILENAME%.exe" "%FILENAME%.cs"
call "%CD%\ildasm" -out:"%FILENAME%.il" "%FILENAME%.exe"
call "%CD%\ildasm" -html -source -output:"%FILENAME%.il.html" "%FILENAME%.exe"
call "%CD%\ilasm" -outpu:"%FILENAME%.il.exe" "%FILENAME%.il"

del /f /q "%FILENAME%.il.res" "%FILENAME%.res" "%FILENAME%.pdb" "%FILENAME%.exe.mdb" >nul 2>&1
