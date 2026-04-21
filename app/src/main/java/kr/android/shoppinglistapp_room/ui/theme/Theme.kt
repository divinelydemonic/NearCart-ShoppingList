package kr.android.shoppinglistapp_room.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// --------------------
// LIGHT COLOR SCHEME
// --------------------
private val LightColors = lightColorScheme(
    primary = GreenPrimary,
    onPrimary = GreenOnPrimary,
    primaryContainer = GreenPrimaryContainer,
    onPrimaryContainer = GreenOnPrimaryContainer,

    secondary = YellowSecondary,
    onSecondary = YellowOnSecondary,
    secondaryContainer = YellowSecondaryContainer,
    onSecondaryContainer = YellowOnSecondaryContainer,

    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,

    error = RedAccent
)

// --------------------
// DARK COLOR SCHEME
// --------------------
private val DarkColors = darkColorScheme(
    primary = GreenPrimaryDark,
    onPrimary = GreenOnPrimaryDark,
    primaryContainer = GreenPrimaryContainerDark,
    onPrimaryContainer = GreenOnPrimaryContainerDark,

    secondary = YellowSecondaryDark,
    onSecondary = YellowOnSecondaryDark,
    secondaryContainer = YellowSecondaryContainerDark,
    onSecondaryContainer = YellowOnSecondaryContainerDark,

    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,

    error = RedAccentDark
)

// --------------------
// MAIN THEME FUNCTION
// --------------------
@Composable
fun ShoppingListApp_RoomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {

        // Dynamic color (Android 12+)
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }

        // Dark theme
        darkTheme -> DarkColors

        // Light theme
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

@Composable
fun resolveDark(mode : ThemeMode) : Boolean {
    return when (mode) {
        ThemeMode.LIGHT -> false
        ThemeMode.DARK -> true
        ThemeMode.SYSTEM -> isSystemInDarkTheme()
    }
}