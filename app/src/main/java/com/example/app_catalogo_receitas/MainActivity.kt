package com.example.app_catalogo_receitas

import android.os.Bundle
import androidx.activity.ComponentActivity
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
        enableEdgeToEdge()
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

                NavHost(navController = navController, startDestination = "lista") {
                    composable("lista") {
                        ListaReceitasScreen(
                            receitas = Receitas.receitas,
                            favoritos = favoritos,
                            onReceitaClick = { navController.navigate("detalhe/${it.id}") },
                            onToggleFavorito = alternarFavorito,
                            onFavoritasClick = { navController.navigate("favoritas") }
                        )
                    }
                    composable("favoritas") {
                        ReceitasFavoritasScreen(
                            favoritas = Receitas.receitas.filter { it.id in favoritos },
                            onReceitaClick = { navController.navigate("detalhe/${it.id}") },
                            onToggleFavorito = alternarFavorito,
                            onVoltar = { navController.popBackStack() }
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
                                onVoltar = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}