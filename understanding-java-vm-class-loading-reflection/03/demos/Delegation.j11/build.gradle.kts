
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
            outputDir = file("out")
        }
    }
    test {
        java {
            setSrcDirs(listOf("test/src"))
        }
    }
}

dependencies {
    implementation(files ("lib/helper.jar"))
}

application {
    mainClassName = "com.pluralsight.Delegation"
}