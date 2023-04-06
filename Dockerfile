FROM openjdk:17
EXPOSE 9090
ADD target/reading-is-good.jar reading-is-good.jar
ENTRYPOINT ["java", "-jar", "/reading-is-good.jar"]