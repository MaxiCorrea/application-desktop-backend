FROM openjdk:11
VOLUME /tmp
ADD ./target/application-desktop-backend.jar application-desktop-backend.jar
ENTRYPOINT ["java","-jar","/application-desktop-backend.jar"]