plugins {
    java
    id("org.springframework.boot") version "3.0.5"
    id("io.spring.dependency-management") version "1.1.0"
    id ("org.flywaydb.flyway") version "9.8.1"

}

group = "com.trpg"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.flywaydb:flyway-core")
    implementation("org.immutables:value:2.9.2")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

dependencies {
    val immutablesVersion = "2.9.2"
    annotationProcessor ("org.immutables:value:$immutablesVersion") // <--- this is important
    compileOnly ("org.immutables:value:$immutablesVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

flyway {
    url = "jdbc:postgresql://localhost:5432/playerIdentityService"
    user = "postgres"
    password = "postgres"
}