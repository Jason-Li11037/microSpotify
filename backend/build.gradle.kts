plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.serialization") version "1.9.25"
    application
}

group = "com.example.microspotify.backend"
version = "0.0.1"

application {
    mainClass.set("com.example.microspotify.backend.ApplicationKt")
}

repositories {
    mavenCentral()
}

val ktorVersion = "2.3.12"
val logbackVersion = "1.4.14"

dependencies {
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
}
