
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

project(":Client") {
    dependencies {
      "implementation"(project(":Interfaces"))
    }

    sourceSets {
        main {
            java {
                outputDir = file("../out/production/client")
            }
        }
    }
}

project(":Implementations") {
    dependencies {
      "implementation"(project(":Interfaces"))
    }

    tasks.jar {
        destinationDirectory.set(file("../out/artifacts/implementations_jar"))
        archiveBaseName.set("implementations")
    }


    sourceSets {
        main {
            java {
                outputDir = file("../out/production/client")
            }
        }
    }

}

project(":Interfaces") {
    dependencies {
    }
    tasks.jar {
        destinationDirectory.set(file("../out/artifacts/interfaces_jar"))
        archiveBaseName.set("interfaces")
    }

    sourceSets {
        main {
            java {
                outputDir = file("../out/production/interfaces")
            }
        }
    }
}

