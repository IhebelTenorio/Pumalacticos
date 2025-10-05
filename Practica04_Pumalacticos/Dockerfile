FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY . /app
RUN mkdir -p out && javac -d out $(find src/main/java -name "*.java")
CMD ["java", "-cp", "out", "com.pumalactivos.rock_buster_app.Rock_Buster_App"]

