# workshop-proguard-debugging

Showcase project for a "ProGuard Debugging" workshop.

## The Problem: Gradual migration to Compose navigation

Gradual migration from Fragment-based navigation to Compose navigation is not an easy task.
The problematic part is a [NavHost](https://developer.android.com/reference/androidx/navigation/NavHost) component.
It can either navigate between fragments or between Compose routes but nothing between.

To achieve a gradual migration we need to divide it in 2 steps:

1. Replace individual destination Fragments by a parametrized generic Fragment. It invokes composable methods using
   reflection.
2. Replace the single generic Fragment at all and navigate using composable methods.

The AndroidX Navigation library also implements this
approach: [navigation-fragment-compose](https://developer.android.com/jetpack/androidx/releases/navigation#2.8.0-alpha07)

Using reflection causes trouble in application Release builds.
R8 (ProGuard) build tool obfuscates and further optimises the code.

The purpose of this project is to outline the problem and come up with a solution in form of proper ProGuard rules.