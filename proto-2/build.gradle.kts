plugins {
    application
    id("com.google.protobuf") version "0.9.4"
}

group = "com.github.allanrodriguez"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("com.example.App")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:2.6.1"
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:2.6.1")
}
