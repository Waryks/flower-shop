FROM openjdk:21
WORKDIR /opt
ENV PORT 8083
EXPOSE 8083
COPY flower-shop/target/flower-shop-1.0.0-SNAPSHOT.jar /opt/app.jar
ENTRYPOINT ["java","-jar","app.jar"]