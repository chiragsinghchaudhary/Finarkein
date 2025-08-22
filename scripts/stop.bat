@echo off
setlocal

set APP_NAME=YourSpringBootApp

REM Find the PID of the Spring Boot application
for /f "tokens=2" %%a in ('tasklist /nh /fi "imagename eq java.exe" ^| findstr /i "%APP_NAME%"') do (
    set PID=%%a
    goto :found_pid
)

:found_pid
if defined PID (
    echo Terminating process with PID: %PID%
    taskkill /PID %PID% /F
    echo %APP_NAME% stopped.
) else (
    echo %APP_NAME% is not running.
)

endlocal