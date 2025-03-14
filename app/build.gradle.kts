import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("java")
    application
    checkstyle
    jacoco
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
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.8.0-M1")
    testImplementation ("org.junit.jupiter:junit-jupiter-params:5.8.0-M1")
    testImplementation ("org.assertj:assertj-core:3.19.0")
    implementation("info.picocli:picocli:4.7.0")
    annotationProcessor("info.picocli:picocli-codegen:4.7.6")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.14.2")
    implementation("org.apache.commons:commons-lang3:3.14.0")
    implementation("org.apache.commons:commons-collections4:4.4")
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.x.x")


}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}

tasks.named("build") {
    dependsOn("checkstyleMain")
    dependsOn("checkstyleTest")
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }



