plugins {
    id("example.conventions.kotlin-common")

    kotlin("plugin.spring") version "1.8.10"
    id("org.springframework.boot") version "3.0.6"
    id("io.spring.dependency-management") version "1.1.0"
}

dependencies {
    // Required by Spring Boot when using Kotlin
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-websocket")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.security:spring-security-messaging")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")

    // JSON logging
    implementation("net.logstash.logback:logstash-logback-encoder:7.2")

    // Verify JSON
    testImplementation("com.jayway.jsonpath:json-path-assert:2.8.0")
    testImplementation("org.hamcrest:hamcrest:2.2")
}

tasks.test { systemProperty("spring.profiles.active", "test") }
