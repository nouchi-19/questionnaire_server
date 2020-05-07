FROM tomcat

ADD ./docker/tomcat/conf /usr/local/tomcat/conf/

ADD ./docker/tomcat/conf/context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml

COPY ./target/questionnaire_server.war /usr/local/tomcat/webapps/questionnaire_server.war

