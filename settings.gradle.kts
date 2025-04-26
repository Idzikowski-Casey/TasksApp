pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "TasksApp"
include(":app")
include(":di")
include(":greeting")
include(":navigation:impl")
include(":navigation:api")
include(":ux:components")
include(":molecule-presenter:api")
include(":molecule-presenter:impl")
include(":viewRenderer:api")
include(":data:api")
include(":viewRenderer:impl")
include(":tasks")
include(":TasksScreen")
