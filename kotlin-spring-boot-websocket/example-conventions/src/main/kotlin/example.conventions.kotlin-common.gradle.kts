import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    kotlin("jvm")

    id("com.diffplug.spotless")
}

group = "io.github.chehsunliu.example"

kotlin {
    jvmToolchain {
        this.languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

spotless {
    kotlin {
        ktfmt("0.44").dropboxStyle()
    }
    kotlinGradle {
        ktfmt("0.44").dropboxStyle()
    }
}
