package com.example.agoraapitest

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.agoraapitest.model.Component
import com.example.agoraapitest.model.Components
import com.example.agoraapitest.model.Example
import com.example.agoraapitest.ui.example.Example
import com.example.agoraapitest.ui.home.Home
import com.example.agoraapitest.ui.settings.Settings

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HomeRoute
    ) {
        composable(HomeRoute) {
            Home(
                components = Components,
                onExampleClick = { example, component -> navController.navigate(example.route(component)) },
                onSettingClick = { navController.navigate(SettingsRoute) }
            )
        }
        composable(SettingsRoute) {
            Settings {
                navController.popBackStack()
            }
        }
        composable(
            route = "$ExampleRoute/" +
                    "{$ComponentIdArgName}/" +
                    "{$ExampleIndexArgName}",
            arguments = listOf(
                navArgument(ComponentIdArgName) { type = NavType.IntType },
                navArgument(ExampleIndexArgName) { type = NavType.IntType }
            )
        ) { navBackStackEntry ->
            val arguments = requireNotNull(navBackStackEntry.arguments) { "No arguments" }
            val componentId = arguments.getInt(ComponentIdArgName)
            val exampleIndex = arguments.getInt(ExampleIndexArgName)
            val component = Components.first { component -> component.id == componentId }
            val example = component.examples[exampleIndex]
            Example(
                example = example,
                onBackClick = { navController.popBackStack() },
            )
        }
    }

}

private fun Example.route(component: Component) =
    "$ExampleRoute/${component.id}/${component.examples.indexOf(this)}"

private const val HomeRoute = "home"
private const val SettingsRoute = "settings"
private const val ExampleRoute = "example"
private const val ComponentIdArgName = "componentId"
private const val ExampleIndexArgName = "exampleIndex"