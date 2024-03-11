pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "plAnt"
include(":plAnt-Mobile")
include(":Core:CoreComposeDesignSystemLib")
include(":Core:CoreLogsLib")
include(":Core:CoreLogsLib")
include(":Core:CoreNavigationLib")
include(":Core:CoreServerRestLib")
