FROM openjdk:17.0.1-jdk-oracle
LABEL authors="neferpitou_"

WORKDIR /app

COPY build/libs/product-service-0.0.1-SNAPSHOT.jar /app/product-service.jar

EXPOSE 8090

CMD ["java", "-jar", "product-service.jar"]

#gradle clean -> build
#docker build -t product-service .
#docker run -p 8090:8090 --net online-shop-network product-service