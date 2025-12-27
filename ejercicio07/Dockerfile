# Imagen base con Java 17
FROM eclipse-temurin:17-jdk

# Directorio de trabajo
WORKDIR /app

# Copiar el jar
COPY target/ejercicio07-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto (Render usa 10000)
EXPOSE 10000

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
