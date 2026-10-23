package com.example.app_catalogo_receitas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.app_catalogo_receitas.ui.screens.DetalhesReceitaScreen
import com.example.app_catalogo_receitas.ui.screens.ListaReceitasScreen
import com.example.app_catalogo_receitas.ui.screens.ReceitasFavoritasScreen
import com.example.app_catalogo_receitas.viewModel.ReceitasViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    viewModel: ReceitasViewModel
) {
    val favoritos by viewModel.favoritos.collectAsStateWithLifecycle()

    // Abas da barra inferior: voltam até a lista antes de abrir o destino,
    // assim a pilha de telas não cresce a cada toque
    val irParaReceitas: () -> Unit = {
        navController.navigate(Rotas.LISTA) {
            popUpTo(Rotas.LISTA)
            launchSingleTop = true
        }
    }
    val irParaFavoritas: () -> Unit = {
        navController.navigate(Rotas.FAVORITAS) {
            popUpTo(Rotas.LISTA)
            launchSingleTop = true
        }
    }

    NavHost(navController = navController, startDestination = Rotas.LISTA) {
        composable(Rotas.LISTA) {
            ListaReceitasScreen(
                receitas = viewModel.receitas,
                favoritos = favoritos,
                onReceitaClick = { navController.navigate(Rotas.detalhe(it.id)) },
                onToggleFavorito = viewModel::alternarFavorito,
                onFavoritasClick = irParaFavoritas
            )
        }
        composable(Rotas.FAVORITAS) {
            ReceitasFavoritasScreen(
                favoritas = viewModel.receitasFavoritas(favoritos),
                onReceitaClick = { navController.navigate(Rotas.detalhe(it.id)) },
                onToggleFavorito = viewModel::alternarFavorito,
                onReceitasClick = irParaReceitas
            )
        }
        composable(
            route = Rotas.DETALHE,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { entry ->
            val id = entry.arguments?.getInt("id")
            val receita = id?.let { viewModel.receitaPorId(it) }
            if (receita != null) {
                DetalhesReceitaScreen(
                    receita = receita,
                    onVoltar = { navController.popBackStack() },
                    favorita = receita.id in favoritos,
                    onToggleFavorito = { viewModel.alternarFavorito(receita) },
                    onReceitasClick = irParaReceitas,
                    onFavoritosClick = irParaFavoritas
                )
            }
        }
    }
}