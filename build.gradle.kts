plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit 5 for running tests
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // Selenium Java bindings
    testImplementation("org.seleniumhq.selenium:selenium-java:4.18.1")
    // Automatically manages driver executables (Chrome, Firefox, etc.)
    testImplementation("io.github.bonigarcia:webdrivermanager:5.7.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
