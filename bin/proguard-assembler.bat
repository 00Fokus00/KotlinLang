@echo off
setlocal enabledelayedexpansion

set "CD=%~dp0"
set "CD=%CD:~0,-1%"

set JAVA=%CD%\java

if exist "%CD%\_props.bat" call "%CD%\_props.bat"


::set PROGUARD_ASSEMBLER="%CD%\.java\proguard-assembler\bin\assembler.bat"
set PROGUARD_ASSEMBLER="%JAVA%" -jar "%CD%\.java\proguard-assembler\lib\assembler.jar"

if exist "%CD%\_props.bat" call "%CD%\_props.bat"


%PROGUARD_ASSEMBLER% %*
