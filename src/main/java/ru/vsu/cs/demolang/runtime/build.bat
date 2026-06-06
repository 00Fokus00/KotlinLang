@echo off

%~d0
cd "%~dp0"

del /f /q *.class >nul 2>&1
if exist ru rd /s /q ru >nul 2>&1

set "CURRENT_DIR=%~dp0"

set "ROOT_DIR=%CURRENT_DIR:\src\main\java\ru\vsu\cs\demolang\runtime\=%"

call "%ROOT_DIR%\bin\javac" --release 17 Runtime.java

if %ERRORLEVEL%==0 (
  echo.
  echo Runtime.class успешно создан:
  echo "%~dp0"
) else (
  echo. 1>&2
  echo Не удалось скомпилировать Runtime.java 1>&2
  pause
)