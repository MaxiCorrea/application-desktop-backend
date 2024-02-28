FROM openjdk:17
VOLUME /tmp
ADD ./target/application-desktop-backend.jar application-desktop-backend.jar
ENTRYPOINT ["java","-jar","/application-desktop-backend.jar","--spring.profiles.active=prod"]