FROM openjdk:17.0.1-oracle
LABEL authors="neferpitou_"

MAINTAINER neferpitou_
COPY target/docker-cart-service-0.0.1-SNAPSHOT.jar cart-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/cart-service-0.0.1-SNAPSHOT.jar"]
