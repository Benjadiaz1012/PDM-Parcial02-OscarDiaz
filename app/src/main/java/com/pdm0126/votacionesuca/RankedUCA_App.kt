package com.pdm0126.votacionesuca

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.votacionesuca.screens.home.HomeScreen
import com.pdm0126.votacionesuca.screens.results.ResultScreen

@Composable
fun RankeUCA_App() {
    val backStack = rememberNavBackStack(Routes.Home)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                HomeScreen(
                    onNext = {backStack.add(Routes.Votes)})
            }
            entry<Routes.Votes> {
                ResultScreen(
                    onBack = {backStack.removeLastOrNull()}
                )
            }
        },
    )


}