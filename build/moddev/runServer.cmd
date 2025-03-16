@echo off
setlocal
for /f "tokens=2 delims=:." %%x in ('chcp') do set _codepage=%%x
chcp 65001>nul
cd C:\Users\ignor\OneDrive\Documents\GitHub\plantFarms\run
"C:\Program Files\Java\jdk-21\bin\java.exe" @C:\Users\ignor\OneDrive\Documents\GitHub\plantFarms\build\moddev\serverRunClasspath.txt @C:\Users\ignor\OneDrive\Documents\GitHub\plantFarms\build\moddev\serverRunVmArgs.txt -Dfml.modFolders=plant_farms%%%%C:\Users\ignor\OneDrive\Documents\GitHub\plantFarms\build\classes\java\main;plant_farms%%%%C:\Users\ignor\OneDrive\Documents\GitHub\plantFarms\build\resources\main net.neoforged.devlaunch.Main @C:\Users\ignor\OneDrive\Documents\GitHub\plantFarms\build\moddev\serverRunProgramArgs.txt
if not ERRORLEVEL 0 (  echo Minecraft failed with exit code %ERRORLEVEL%  pause)
chcp %_codepage%>nul
endlocal