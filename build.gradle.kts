plugins {
    java
    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.graalvm.buildtools.native") version "0.9.18"
    id("maven-publish")
    id("org.jetbrains.kotlin.jvm") version "1.7.0"
}

group = "com.wuwii"
version = "0.0.8-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    maven("https://maven.aliyun.com/repository/public")
    maven("https://maven.aliyun.com/repository/central")
    maven {
        url = uri("https://packages.aliyun.com/maven/repository/2054354-snapshot-vSXJCj/")
        credentials {
            username = System.getenv("REP_USERNAME")
            password = System.getenv("REP_PASSWORD")
        }
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-autoconfigure")
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("org.slf4j:slf4j-api:2.0.6")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// 打包到本地仓库 https://docs.gradle.org/current/userguide/publishing_maven.html
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            version = this.version
            from(components["java"])
        }
    }
//    打包到远程仓库
    repositories {
        mavenLocal()
        maven {
//            val releasesRepoUrl = layout.buildDirectory.dir("repos/releases")
//            val snapshotsRepoUrl = layout.buildDirectory.dir("repos/snapshots")
            val releasesRepoUrl = "https://packages.aliyun.com/maven/repository/2054354-release-vDohVl/"
            val snapshotsRepoUrl = "https://packages.aliyun.com/maven/repository/2054354-snapshot-vSXJCj/"
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
            credentials {
                username = System.getenv("REP_USERNAME")
                password = System.getenv("REP_PASSWORD")
            }
        }

    }
}
