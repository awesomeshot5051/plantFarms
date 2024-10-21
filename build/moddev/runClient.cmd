@echo off
setlocal
for /f "tokens=2 delims=:." %%x in ('chcp') do set _codepage=%%x
chcp 65001>nul
cd D:\MCreatorWorkspaces\plantFarms\run
"C:\Program Files\Java\jdk-21\bin\java.exe" @D:\MCreatorWorkspaces\plantFarms\build\moddev\clientRunClasspath.txt @D:\MCreatorWorkspaces\plantFarms\build\moddev\clientRunVmArgs.txt -Dfml.modFolders=plant_farms%%%%D:\MCreatorWorkspaces\plantFarms\build\classes\java\main;plant_farms%%%%D:\MCreatorWorkspaces\plantFarms\build\resources\main net.neoforged.devlaunch.Main @D:\MCreatorWorkspaces\plantFarms\build\moddev\clientRunProgramArgs.txt
if not ERRORLEVEL 0 (  echo Minecraft failed with exit code %ERRORLEVEL%  pause)
chcp %_codepage%>nul
endlocal