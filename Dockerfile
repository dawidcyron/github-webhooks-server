FROM java:8
EXPOSE 8000
ADD /target/github-webhooks-handler-0.0.1-SNAPSHOT.jar github-webhooks-handler.jar
CMD ["java", "-jar", "github-webhooks-handler.jar"]