package com.example.app_catalogo_receitas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.app_catalogo_receitas.data.Receitas
//import com.example.app_catalogo_receitas.ui.screens.DetalheReceitaScreen
import com.example.app_catalogo_receitas.ui.screens.ListaReceitasScreen
import com.example.app_catalogo_receitas.ui.theme.App_Receita_CatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App_Receita_CatalogoTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "lista") {
                    composable("lista") {
                        ListaReceitasScreen(
                            receitas = Receitas.receitas,
                            onReceitaClick = { navController.navigate("detalhe/${it.id}") }
                        )
                    }
                    composable(
                        route = "detalhe/{id}",
                        arguments = listOf(navArgument("id") { type = NavType.IntType })
                    ) { entry ->
                        val id = entry.arguments?.getInt("id")
                        val receita = id?.let { Receitas.porId(it) }
//                        if (receita != null) {
//                            DetalheReceitaScreen(
//                                receita = receita,
//                                onVoltar = { navController.popBackStack() }
//                            )
//                        }
                    }
                }
            }
        }
    }
}