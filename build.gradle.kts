plugins {
    id("java")
    base
    `java-library`
    application
}

group = "dev.folomkin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-api
    implementation("org.slf4j:slf4j-api:2.0.17")
    runtimeOnly("org.slf4j:slf4j-simple:2.0.17")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("dev.folomkin.Main")
}

tasks.jar {
    manifest {
        attributes("Main-Class" to application.mainClass.get())
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("my-task") {
    println("конфигурируем")
    doLast {
        println("Привет от Gradle")
    }
}