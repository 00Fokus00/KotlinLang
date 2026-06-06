@echo off
setlocal enabledelayedexpansion

set "CD=%~dp0"
set "CD=%CD:~0,-1%"

set JAVA=%CD%\java

if exist "%CD%\_props.bat" call "%CD%\_props.bat"


::set PROGUARD="%CD%\.java\proguard\bin\proguard.bat"
set PROGUARD="%JAVA%" -jar "%CD%\.java\proguard\lib\proguard.jar"

if exist "%CD%\_props.bat" call "%CD%\_props.bat"


%PROGUARD% %*
