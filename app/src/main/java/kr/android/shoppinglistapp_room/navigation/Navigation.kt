@file:OptIn(ExperimentalAnimationApi::class)

package kr.android.shoppinglistapp_room.navigation

import android.content.Context
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import kr.android.shoppinglistapp_room.ui.theme.ThemeMode
import kr.android.shoppinglistapp_room.view.HomeScreen

@Composable
fun Navigation (
    modifier : Modifier,
    themeMode : ThemeMode,
    onThemeChange : (ThemeMode) -> Unit,
    navController : NavHostController,
    context : Context
) {
    AnimatedNavHost(
      navController = navController,
        startDestination = Screens.HomeScreen.route
    ){
        composable(
            route = Screens.HomeScreen.route
        ){
            HomeScreen(
                themeMode = themeMode,
                onThemeChange = onThemeChange,
                navController = navController
            )
        }
    }
}