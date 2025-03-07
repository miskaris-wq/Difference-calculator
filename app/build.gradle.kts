plugins {
    id("java")
    application
    checkstyle
    id("com.github.ben-manes.versions") version "0.52.0"
}
application {
    mainClass = "hexlet.code.App"
}
group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.0")
    annotationProcessor("info.picocli:picocli-codegen:4.7.6")
}

tasks.test {
    useJUnitPlatform()
}

