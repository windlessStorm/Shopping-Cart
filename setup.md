**Setup**
-----

Extract the apache-tomcat-9.0.1.

Environment variables Go to Control Panel\System and Security\System Next is Advanced system settings --> Go to Advanced tab --> Environment Variables Basically its setting your classpath so that you can execute your Java code from anywhere.

Add the following three variables and values :

JAVA_HOME 
C:\Program Files\Java\jdk1.8.0_51\bin

JRE_HOME 
C:\Program Files\Java\jre1.8.0_131

CATALINA_HOME 
Your apache extract folder\apache-tomcat-9.0.1

And there will be a path variable. Add this line.

%CATALINA_HOME%\bin

You can configure the hibernate.cfg file for your settings of database and password. 
But if you have a Oracle 9, you can just create a user with credentials: 
username - satyaki 
password - qwerty 

Fire up the CMD. Type startup.bat And Hit Enter.

Open http://localhost:8080/Shopping/ in your browser.
