# 1단계: 빌드 단계 (Gradle Wrapper 사용)
FROM gradle:8.5.0-jdk17 AS builder
WORKDIR /app

# 의존성 캐시 최적화를 위해 먼저 복사
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# 의존성 캐시
RUN ./gradlew build -x test || return 0

# 소스 복사 및 빌드
COPY . .
RUN ./gradlew clean bootJar -x test

# 2단계: 실행 단계 (경량 JDK 이미지 사용)
FROM openjdk:17-jdk-slim
WORKDIR /app

# 빌드된 JAR 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 포트 설정
EXPOSE 8080

# 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar"]