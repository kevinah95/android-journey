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
// Unit 01
include(":unit01:pathway03:HappyBirthday")
include(":unit01:pathway03:ComposeArticle")
include(":unit01:pathway03:TaskManager")
include(":unit01:pathway03:ComposeQuadrant")
include(":unit01:pathway03:BusinessCard")
// Unit 02
include(":unit02:pathway02:DiceRoller")
include(":unit02:pathway02:Lemonade")
include(":unit02:pathway03:TipTime")
include(":unit02:pathway03:ArtSpace")
// Unit 03
include(":unit03:pathway02:AffirmationsApp")
// Unit 04
include(":unit04:pathway01:DessertClicker")
include(":unit04:pathway01:Unscramble")
