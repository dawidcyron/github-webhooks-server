FROM java:8
EXPOSE 8000
ADD /target/github-webhooks-handler-1.0.0-RELEASE.jar github-webhooks-handler.jar
CMD ["java", "-jar", "github-webhooks-handler.jar"]