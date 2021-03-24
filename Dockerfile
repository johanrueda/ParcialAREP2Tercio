FROM openjdk:8

WORKDIR /usrapp/bin

ENV PORT 5000

COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.escuelaing.arem.app.App"]