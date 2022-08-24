import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    `maven-publish`
}

object Const {
    const val groupId = "io.github.fishb1"
    const val artifact = "apk-info"
    const val version = "1.0.0"
}

group = Const.groupId
version = Const.version

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = Const.groupId
            artifactId = Const.artifact
            version = Const.version

            from(components["java"])
        }
    }
}
