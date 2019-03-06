FROM maven:3.5.2-jdk-8-alpine
WORKDIR /user/app
COPY pom.xml .
COPY src/ .
RUN mvn clean package # -Dmaven.test.skip=true -X

FROM openjdk:8-jre
WORKDIR /user/app
COPY --from=0 /user/app/target/toystore.jar .
CMD java -jar toystore.jar