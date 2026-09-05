@echo off
title Dasbor Mobile Local Server
cls
echo Memulai server aplikasi Dasbor Mobile...
powershell -NoProfile -ExecutionPolicy Bypass -File "%~dp0run_server.ps1"
pause
