package com.example.app_catalogo_receitas

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.app_catalogo_receitas.data.Receitas
import com.example.app_catalogo_receitas.model.Receita
import com.example.app_catalogo_receitas.ui.screens.DetalhesReceitaScreen
import com.example.app_catalogo_receitas.ui.screens.ListaReceitasScreen
import com.example.app_catalogo_receitas.ui.screens.ReceitasFavoritasScreen
import com.example.app_catalogo_receitas.ui.theme.AppCatalogoReceitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // O app usa tema claro: ícones escuros na barra de status e na de navegação
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
        )
        setContent {
            AppCatalogoReceitaTheme {
                val navController = rememberNavController()

                // IDs das receitas favoritas (sobrevive à rotação de tela)
                var favoritosIds by rememberSaveable { mutableStateOf(listOf<Int>()) }
                val favoritos = favoritosIds.toSet()

                val alternarFavorito: (Receita) -> Unit = { receita ->
                    favoritosIds = if (receita.id in favoritosIds) {
                        favoritosIds - receita.id
                    } else {
                        favoritosIds + receita.id
                    }
                }

                // Abas da barra inferior: voltam até a lista antes de abrir o destino,
                // assim a pilha de telas não cresce a cada toque
                val irParaReceitas: () -> Unit = {
                    navController.navigate("lista") {
                        popUpTo("lista")
                        launchSingleTop = true
                    }
                }
                val irParaFavoritas: () -> Unit = {
                    navController.navigate("favoritas") {
                        popUpTo("lista")
                        launchSingleTop = true
                    }
                }

                NavHost(navController = navController, startDestination = "lista") {
                    composable("lista") {
                        ListaReceitasScreen(
                            receitas = Receitas.receitas,
                            favoritos = favoritos,
                            onReceitaClick = { navController.navigate("detalhe/${it.id}") },
                            onToggleFavorito = alternarFavorito,
                            onFavoritasClick = irParaFavoritas
                        )
                    }
                    composable("favoritas") {
                        ReceitasFavoritasScreen(
                            favoritas = Receitas.receitas.filter { it.id in favoritos },
                            onReceitaClick = { navController.navigate("detalhe/${it.id}") },
                            onToggleFavorito = alternarFavorito,
                            onReceitasClick = irParaReceitas
                        )
                    }
                    composable(
                        route = "detalhe/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { entry ->
                        val id = entry.arguments?.getInt("id")
                        val receita = id?.let { Receitas.porId(it) }
                        if (receita != null) {
                            DetalhesReceitaScreen(
                                receita = receita,
                                onVoltar = { navController.popBackStack() },
                                favorita = receita.id in favoritos,
                                onToggleFavorito = { alternarFavorito(receita) },
                                onReceitasClick = irParaReceitas,
                                onFavoritosClick = irParaFavoritas
                            )
                        }
                    }
                }
            }
        }
    }
}