@echo off
setlocal enabledelayedexpansion

set "CD=%~dp0"
set "CD=%CD:~0,-1%"

if exist "%CD%\_props.bat" call "%CD%\_props.bat"


set JAVAC=javac.exe

if exist "%CD%\_props.bat" call "%CD%\_props.bat"


%JAVAC% %*
