In this project, we built a tiered application, using Java EE technologies. The goal was to simulate a scenario where we need to query data and integrate services. We used a data persistence tool (JPA/Hibernate) to manage data about researchers. Next, we built EJBs to provide access to the JPA managed information and web services (provided by the application server) to provide operations to a web service client application. Finally, we created a web front-end to provide information to users using browsers.

To execute this application, it is necessary to have installed postgres. The password used is 'postgres'. In case of your password is different, you should change this information on the file find at proj2/wildfly-24.0.0.Final/standalone/configuration/standalone-full.xml, at the database password information.

The package already has all the dependencies and plugins needed to run the application. In order to execute the project, the first step is to start the server. Open a terminal and go to wildfly-24.0.0.Final directory and run the following command: bin/standalone.sh --server-config=standalone-full.xml. 

The second step is to open the client console application. It is necessary to run the following command: java -jar target/client.jar. By now, you should be able to see at the command window a menu with 10 options to access the researchers and publications database. 

In order to access the web front-end, you should go tho the following link: 
http://localhost:8080/web/webaccess.

* All the commands above works in MACOS, for Windows, some changes need to be done, namely on the directories access. 