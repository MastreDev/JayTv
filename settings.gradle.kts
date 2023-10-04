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

rootProject.name = "JayTv"
include(":app:mobile")
include(":app:tv")
include(":feature:player")
include(":playlist")
include(":playlist:data")
include(":feature:home")
