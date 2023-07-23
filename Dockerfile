FROM bellsoft/liberica-runtime-container:jre-17-stream-musl
EXPOSE 8080
ADD target/my-portfolio-spring-boot.jar my-portfolio-spring-boot.jar
ENTRYPOINT ["java","-jar","/my-portfolio-spring-boot.jar"]