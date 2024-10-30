import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    `java-library`
    `maven-publish`
    id("com.google.protobuf") version "0.9.4"
    id("com.gradleup.shadow") version "8.3.3"
}

group = "com.github.allanrodriguez"
version = "1.0-SNAPSHOT"

java {
    withJavadocJar()
    withSourcesJar()
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.5"
    }
}

tasks.named("shadowJar", ShadowJar::class) {
    relocate("com.google.protobuf", "com.github.allanrodriguez.shadow.com.google.protobuf")
}

components.named("shadow", AdhocComponentWithVariants::class) {
    addVariantsFromConfiguration(configurations["javadocElements"]) {
        mapToMavenScope("runtime")
    }

    addVariantsFromConfiguration(configurations["sourcesElements"]) {
        mapToMavenScope("runtime")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["shadow"])
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:3.25.5")
    implementation("com.google.protobuf:protobuf-java-util:3.25.5")
}
