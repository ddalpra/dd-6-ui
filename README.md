# dd-6-ui

##compile, package.
Maven command use to compile and package the application `mvn clean compile package`

#run the application
for testing the application you must user this command`java -jar target/dd-6-ui-bootable.jar`

##Build a docker image for the use from kubernates
To build the container use this command `docker build -t dd-6-ui:v1.0.0 -f src/main/docker/Dockerfile .`

##Run a container to test.
To run the container use this command `docker run -p 18080:8080 dd-6-ui:v1.0.0`
