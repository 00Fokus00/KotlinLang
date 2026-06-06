@echo off
setlocal enabledelayedexpansion

rem Предварительно скачать и установить .NET 10.0 со страницы:
rem   https://dotnet.microsoft.com/en-us/download/dotnet/10.0

::exit

set TEMP_PACKAGE_NAME=__temp_project__

rem Создать временный проект
dotnet new console -n %TEMP_PACKAGE_NAME%

cd ./%TEMP_PACKAGE_NAME%

rem Добавить пакеты
dotnet add package runtime.win-x64.microsoft.netcore.ildasm
dotnet add package runtime.win-x64.microsoft.netcore.ilasm

rem Восстановить пакеты
dotnet restore

rem Пакет теперь в ~/.nuget/packages/
cd ..
rmdir /s /q .\%TEMP_PACKAGE_NAME% 2>nul
