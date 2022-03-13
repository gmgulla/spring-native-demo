FROM ghcr.io/graalvm/graalvm-ce:latest AS builder
COPY ./ /app
WORKDIR /app
RUN ./mvnw -Pnative -DskipTests package

FROM debian:latest
COPY --from=builder /app/target/spring-native-demo /app/spring-native-demo
EXPOSE 8080:8080
CMD ["/app/spring-native-demo"]