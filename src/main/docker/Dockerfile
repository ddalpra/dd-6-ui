# Specify the parent image from which we build
FROM registry.access.redhat.com/ubi8/openjdk-17:1.14

ENV LANGUAGE='en_US:en'

COPY --chown=185 target/*.jar /work/app.jar

EXPOSE 8080
USER 185

ENTRYPOINT ["java","-jar","/work/app.jar"]
