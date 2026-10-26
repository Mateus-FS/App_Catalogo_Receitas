package com.example.app_catalogo_receitas

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.app_catalogo_receitas.ui.navigation.AppNavGraph
import com.example.app_catalogo_receitas.ui.theme.AppCatalogoReceitaTheme
import com.example.app_catalogo_receitas.viewModel.ReceitasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
        )
        setContent {
            AppCatalogoReceitaTheme {
                val navController = rememberNavController()
                val viewModel: ReceitasViewModel = viewModel()
                AppNavGraph(navController, viewModel)
            }
        }
    }
}