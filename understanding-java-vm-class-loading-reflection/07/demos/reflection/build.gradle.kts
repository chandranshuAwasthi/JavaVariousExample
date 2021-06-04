
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
            outputDir = file("out/production")
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