# Specify the parent image from which we build
FROM quay.io/quarkus/ubi-quarkus-native-image:22.3-java11

ENV LANGUAGE='en_US:en'

COPY --chown=185 target/*.jar /work/app.jar

EXPOSE 8080
USER 185

ENTRYPOINT ["java","-jar","/work/app.jar"]
