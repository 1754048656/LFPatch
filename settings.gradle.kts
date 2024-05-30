enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal {
            content {
                includeGroup("io.github.libxposed")
            }
        }
    }
    versionCatalogs {
        create("libs") {
            from(files("f-core/gradle/libs.versions.toml"))
        }
        create("lspatch") {
            from(files("gradle/lspatch.versions.toml"))
        }
    }
}

rootProject.name = "LFPatch"
include(
    ":apkzlib",
    ":core",
    ":hiddenapi:bridge",
    ":hiddenapi:stubs",
    ":jar",
    ":manager",
    ":meta-loader",
    ":patch",
    ":patch-loader",
    ":services:daemon-service",
    ":services:manager-service",
    ":services:xposed-service:interface",
    ":share:android",
    ":share:java",
)

project(":core").projectDir = file("f-core/core")
project(":hiddenapi:bridge").projectDir = file("f-core/hiddenapi/bridge")
project(":hiddenapi:stubs").projectDir = file("f-core/hiddenapi/stubs")
project(":services:daemon-service").projectDir = file("f-core/services/daemon-service")
project(":services:manager-service").projectDir = file("f-core/services/manager-service")
project(":services:xposed-service:interface").projectDir = file("f-core/services/xposed-service/interface")

buildCache { local { removeUnusedEntriesAfterDays = 1 } }
