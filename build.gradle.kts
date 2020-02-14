import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("jacoco")
    id("com.github.kt3k.coveralls") version "2.8.4"
    kotlin("jvm") version "1.3.61"
    kotlin("plugin.spring") version "1.3.61"
}

group = "com.playcoin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
jacoco {
    toolVersion = "0.8.5"
}

val developmentOnly by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}


repositories {
    mavenCentral()
    maven { url = uri("https://plugins.gradle.org/m2/") }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.squareup.retrofit2:retrofit:2.7.0")
    implementation("com.squareup.retrofit2:converter-gson:2.7.0")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}


tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict", "-Xallow-result-return-type")
        jvmTarget = "1.8"
    }
}

// kotlin DSL

tasks.jacocoTestReport {
    reports {
        // 원하는 리포트를 켜고 끌 수 있습니다.
        html.isEnabled = true
        xml.isEnabled = false
        csv.isEnabled = false

//  각 리포트 타입 마다 리포트 저장 경로를 설정할 수 있습니다.
//  html.destination = file("$buildDir/jacocoHtml")
//  xml.destination = file("$buildDir/jacoco.xml")
    }
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            element = "CLASS"

            limit {
                counter = "BRANCH"
                value = "COVEREDRATIO"
                minimum = "0.90".toBigDecimal()
            }
        }
    }
}
