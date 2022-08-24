import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    `maven-publish`
    signing
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
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

tasks.withType<JavaCompile> {
    sourceCompatibility = JavaVersion.VERSION_1_8.toString()
    targetCompatibility = JavaVersion.VERSION_1_8.toString()
}

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    repositories {
        maven {
            name = "OSSRH"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = System.getenv("SONATYPE_USERNAME")
                password = System.getenv("SONATYPE_PASSWORD")
            }
        }
    }

    publications {
        create<MavenPublication>("maven") {
            groupId = Const.groupId
            artifactId = Const.artifact
            version = Const.version

            from(components["java"])

            pom {
                name.set("apk-info")
                description.set("A Kotlin/Java library for reading basic metadata from an APK file.")
                url.set("https://github.com/fishb1/ApkInfo")

                developers {
                    developer {
                        name.set("Nikolay Sinelnikov")
                        email.set("throyandify@gmail.com")
                        url.set("https://github.com/fishb1")
                    }
                }

                licenses {
                    license {
                        name.set("MIT license")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                    license {
                        name.set("Apache 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0")
                    }
                }

                scm {
                    connection.set("scm:git:https://github.com/fishb1/ApkInfo.git")
                    developerConnection.set("scm:git:git@github.com:fishb1/ApkInfo.git")
                    url.set("https://github.com/fishb1/ApkInfo")
                }
            }
        }
    }
}

signing {
    sign(extensions.getByType<PublishingExtension>().publications.named("maven").get())
}
