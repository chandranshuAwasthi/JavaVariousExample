
plugins {
    application
}

repositories {
    jcenter()
}


sourceSets {
    main {
        java {
            setSrcDirs(listOf("src"))
            outputDir = file("classes")
        }
    }
    test {
        java {
            setSrcDirs(listOf("test/src"))
        }
    }
}

dependencies {
}

tasks.jar {
    destinationDirectory.set(file("lib"))
    archiveBaseName.set("helper")
    includes.add("**/*Helper*")
}

application {
    mainClassName = "com.pluralsight.Main"
}