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

rootProject.name = "Android Journey"
include(":unit01:pathway03:HappyBirthday")
include(":unit01:pathway03:ComposeArticle")
include(":unit01:pathway03:TaskManager")
include(":unit01:pathway03:ComposeQuadrant")
include(":unit01:pathway03:BusinessCard")
include(":unit02:pathway02")
include(":unit02:pathway02:DiceRoller")
include(":unit02:pathway02:Lemonade")
