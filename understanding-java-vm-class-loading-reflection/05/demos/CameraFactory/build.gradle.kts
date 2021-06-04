
plugins {
  java
}

java {                                      
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}


subprojects {

  apply(plugin = "java")
  
  repositories {
    jcenter()
   }

   sourceSets {
        main {
            java {
                setSrcDirs(listOf("src"))
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

}

project(":Camera") {
    dependencies {
      "implementation"(project(":CameraLib"))
      implementation("com.fasterxml.jackson.core:jackson-core:2.4.2")
      implementation("com.fasterxml.jackson.core:jackson-annotations:2.4.2")
        implementation("com.fasterxml.jackson.core:jackson-databind:2.4.2")
        implementation("javax.json:javax.json-api:1.0")
    }

    repositories {
        flatDir {
            dirs("lib")
        }
    }

    sourceSets {
        main {
            java {
                outputDir = file("../out/production/Camera")
            }
        }
    }
}

project(":CameraLib") {
    dependencies {
    }

    tasks.jar {
        destinationDirectory.set(file("../out/artifacts/implementations_jar"))
        archiveBaseName.set("implementations")
    }


    sourceSets {
        main {
            java {
                outputDir = file("../out/production/CameraLib")
            }
        }
    }

}

