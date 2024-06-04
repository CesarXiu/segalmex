FROM openjdk:8-alpine

COPY target/uberjar/segalmex.jar /segalmex/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/segalmex/app.jar"]
