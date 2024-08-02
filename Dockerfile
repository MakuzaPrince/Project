FROM tomcat:10.1 

COPY . /app

WORKDIR /app

RUN rm -rf webapps/*

COPY build/Record.war webapps/Record.war

EXPOSE 8080

CMD ["catalina.sh", "run"]