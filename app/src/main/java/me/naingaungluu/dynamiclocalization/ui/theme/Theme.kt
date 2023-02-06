package me.naingaungluu.dynamiclocalization.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    primary = CodigoRed,
    onPrimary = Color.White,
    primaryVariant = Color.White,
    background = Color.White,
    secondary = CodigoRed,
    onBackground = CodigoBlack,
    onSurface = Color.White
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = Color.White,
    onPrimary = CodigoRed,
    primaryVariant = CodigoRed,
    secondary = CodigoRed,
    secondaryVariant = CodigoRed,
    background = CodigoRed,
    onBackground = Color.White,
    onSurface = Color.DarkGray,
)

@Composable
fun DynamicLocalizationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}