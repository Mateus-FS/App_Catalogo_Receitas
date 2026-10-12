package com.example.app_catalogo_receitas.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val EsquemaClaro = lightColorScheme(
    primary = Verde,
    onPrimary = Color.White,
    secondary = Verde,
    background = Fundo,
    onBackground = TextoPrincipal,
    surface = Superficie,
    onSurface = TextoPrincipal,
    surfaceVariant = ChipFundo,
    onSurfaceVariant = TextoSecundario,
    outlineVariant = Borda,
    error = Favorito
)

@Composable
fun AppCatalogoReceitaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = EsquemaClaro,
        typography = Typography,
        content = content
    )
}