FROM amazoncorretto:8 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM amazoncorretto:8
WORKDIR game-action
COPY --from=build target/*.jar game-action.jar
ENTRYPOINT ["java", "-jar", "game-action.jar"]