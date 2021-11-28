FROM gradle:7-alpine as build
WORKDIR /usr/share/app
COPY . ./
RUN gradle build --exclude-task test


FROM openjdk:8-jre-alpine as prod
COPY --from=build /usr/share/app/build/libs/EndToEnd-0.0.1-SNAPSHOT.jar /
CMD ["java", "-jar", "EndToEnd-0.0.1-SNAPSHOT.jar"]
