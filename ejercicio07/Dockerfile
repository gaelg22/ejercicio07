# =========================
# ETAPA 1: BUILD
# =========================
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copiamos todo el proyecto
COPY . .

# Damos permisos y compilamos
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# =========================
# ETAPA 2: RUN
# =========================
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiamos el jar generado desde la etapa build
COPY --from=build /app/target/*.jar app.jar

# Render usa el puerto 10000
EXPOSE 10000

# Arranque
CMD ["java", "-jar", "app.jar"]
