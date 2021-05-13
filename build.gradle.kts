import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    application
}

group = "me.manug"
version = "1.0-SNAPSHOT"

sourceSets {
    main {
        java.srcDir("src/main/kotlin")
    }
    test {
        java.srcDir("src/test/kotlin")
    }
}

repositories {
    jcenter()
    mavenCentral()
    google()
}

dependencies {
    testImplementation(kotlin("test-junit"))
    testImplementation("io.ktor:ktor-server-test-host:1.4.0")
    testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")
    implementation("io.ktor:ktor-server-netty:1.4.0")
    implementation("io.ktor:ktor-html-builder:1.4.0")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.7.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.8.+")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}
