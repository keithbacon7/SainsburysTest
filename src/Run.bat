REM * * * * * Runs this project 
REM Must be run from the project root directory. 

SET CLASSPATH="target/SainsburysTest-0.0.1-SNAPSHOT.jar"
                           
SET CMD=java -classpath %CLASSPATH%  sainsburystest.RunAsCommand
REM echo %CMD%

%CMD%

