import com.adarshr.gradle.testlogger.theme.ThemeType

plugins {
    application
    id ("com.adarshr.test-logger") version "2.0.0"
}

repositories {
    flatDir {
        dirs("lib", "unittestlib")
    }
    jcenter()
}

tasks.compileJava {
    options.compilerArgs.add("-parameters")
}

tasks.compileTestJava {
    options.compilerArgs.add("-parameters")
}

sourceSets {
    main {
        java {
            setSrcDirs(listOf("src/main"))
            outputDir = file("out/production")
        }
    }
    test {
        java {
            setSrcDirs(listOf("src/tests"))
            outputDir = file("out/test")
        }
    }
}

dependencies {
    implementation("com.fasterxml.jackson.core:jackson-core:2.4.2")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.4.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.4.2")
    implementation("javax.json:javax.json-api:1.0")

    testImplementation("junit:junit:4.12")
    testImplementation("org.hamcrest:hamcrest-core:1.3")
}

tasks {
    testlogger {
        theme=ThemeType.PLAIN
        showExceptions=true
        showStackTraces=true
        showFullStackTraces=false
        showCauses=true
        slowThreshold=2000
        showSummary=true
        showSimpleNames=false
        showPassed=true
        showSkipped=true
        showFailed=true
        showStandardStreams=false
        showPassedStandardStreams=true
        showSkippedStandardStreams=true
        showFailedStandardStreams=true
    }
}

application {
    mainClassName = "com.mantiso.Main"
}