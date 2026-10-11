plugins {
    kotlin("jvm") version "1.9.25"
    application
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("com.example.microspotify.practice.kotlin101.MainKt")
}
