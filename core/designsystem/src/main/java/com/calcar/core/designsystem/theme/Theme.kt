package com.calcar.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/**
 * Light default theme color scheme
 */
private val CalcarLightColors = lightColorScheme(
    primary = Purple40,
    onPrimary = Color.White,
    primaryContainer = Purple90,
    onPrimaryContainer = Purple10,
    secondary = PurpleGray40,
    onSecondary = Color.White,
    secondaryContainer = PurpleGray90,
    onSecondaryContainer = PurpleGray10,
    tertiary = Garnet40,
    onTertiary = Color.White,
    tertiaryContainer = Garnet90,
    onTertiaryContainer = Garnet10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = Neutral99,
    onBackground = Neutral10,
    surface = Neutral99,
    onSurface = Neutral10,
    surfaceVariant = NeutralVariant90,
    onSurfaceVariant = NeutralVariant30,
    outline = NeutralVariant50
)

/**
 * Dark default theme color scheme
 */
private val CalcarDarkColors = darkColorScheme(
    primary = Purple80,
    onPrimary = Purple20,
    primaryContainer = Purple30,
    onPrimaryContainer = Purple90,
    secondary = PurpleGray80,
    onSecondary = PurpleGray20,
    secondaryContainer = PurpleGray30,
    onSecondaryContainer = PurpleGray90,
    tertiary = Garnet80,
    onTertiary = Garnet20,
    tertiaryContainer = Garnet30,
    onTertiaryContainer = Garnet90,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = Neutral10,
    onBackground = Neutral90,
    surface = Neutral10,
    onSurface = Neutral90,
    surfaceVariant = NeutralVariant30,
    onSurfaceVariant = NeutralVariant80,
    outline = NeutralVariant60
)

/**
 * Calcar theme
 *
 * @param useDarkTheme Whether the theme should use a dark color scheme
 * @param useDynamicTheme Whether the theme should use dynamic theming
 */
@Composable
fun CalcarTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    useDynamicTheme: Boolean = true,
    content: @Composable () -> Unit,
) {
    val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val colorScheme = when {
        useDynamicTheme && dynamicColor -> {
            val context = LocalContext.current
            if (useDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        useDarkTheme -> CalcarDarkColors
        else -> CalcarLightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = CalcarTypography,
        content = content
    )
}