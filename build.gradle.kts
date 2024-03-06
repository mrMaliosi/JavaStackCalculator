plugins {
    id("java")
}

group = "ru.nsu.ccfit.malinovskii"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("org.apache.logging.log4j:log4j-api:2.23.0")
    implementation ("org.apache.logging.log4j:log4j-core:2.23.0")
}

tasks.test {
    useJUnitPlatform()
}