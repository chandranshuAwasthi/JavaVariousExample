
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

application {
    mainClassName = "com.pluralsight.Main"
}