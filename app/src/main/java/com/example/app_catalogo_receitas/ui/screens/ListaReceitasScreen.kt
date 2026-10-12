package com.example.app_catalogo_receitas.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app_catalogo_receitas.model.Receita
import com.example.app_catalogo_receitas.ui.components.ReceitaCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaReceitasScreen(
    receitas: List<Receita>,
    favoritos: Set<Int>,
    onReceitaClick: (Receita) -> Unit,
    onToggleFavorito: (Receita) -> Unit,
    onFavoritasClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Catálogo de Receitas") },
                actions = {
                    IconButton(onClick = onFavoritasClick) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Ver favoritas"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(receitas, key = { it.id }) { receita ->
                ReceitaCard(
                    receita = receita,
                    favorita = receita.id in favoritos,
                    onClick = { onReceitaClick(receita) },
                    onToggleFavorito = { onToggleFavorito(receita) }
                )
            }
        }
    }
}