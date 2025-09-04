cd "C:\apache-tomcat\bin"
call shutdown.bat

xcopy /s target\social-media-woohoo.war C:\apache-tomcat\webapps\

cd "C:\apache-tomcat\bin"
call startup.bat

start http://localhost:8080/social-media-woohoo/