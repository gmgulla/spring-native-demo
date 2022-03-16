FROM ghcr.io/graalvm/graalvm-ce:latest AS native-builder
COPY ./ /app
WORKDIR /app
RUN ./mvnw -DskipTests package
RUN mkdir -p target/native
WORKDIR target/native
RUN jar -xvf ../spring-native-demo-0.0.1-SNAPSHOT.jar > /dev/null 2>&1
RUN cp -R META-INF BOOT-INF/classes
RUN gu install native-image
RUN native-image -H:Name=spring-native-demo -cp BOOT-INF/classes:`find BOOT-INF/lib | tr '\n' ':'`

FROM debian:latest
COPY --from=native-builder /app/target/native/spring-native-demo /app/spring-native-demo
EXPOSE 8080:8080
WORKDIR /app
CMD ["./spring-native-demo"]
