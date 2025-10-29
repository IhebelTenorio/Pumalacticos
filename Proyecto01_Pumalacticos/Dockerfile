FROM eclipse-temurin:17-jdk-jammy AS builder
WORKDIR /app
COPY . .
RUN find src -name "*.java" | xargs javac -d .
FROM eclipse-temurin:17-jre-jammy AS runtime
WORKDIR /app
RUN mkdir -p /app/generados
COPY --from=builder /app/PUMABANK ./PUMABANK
COPY --from=builder /app/src/PUMABANK ./src/PUMABANK
ENTRYPOINT ["java", "PUMABANK.PumaBankApp"]
