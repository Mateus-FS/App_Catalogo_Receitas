package com.example.app_catalogo_receitas.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.app_catalogo_receitas.model.Receita

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaReceitasScreen(
    receitas: List<Receita>,
    onReceitaClick: (Receita) -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Catálogo de Receitas") }) }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(receitas, key = { it.id }) { receita ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onReceitaClick(receita) }
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(receita.imagem),
                            contentDescription = receita.titulo,
                            modifier = Modifier.size(72.dp)
                        )
                        Spacer(Modifier.width(12.dp))
                        Column {
                            Text(receita.titulo, style = MaterialTheme.typography.titleMedium)
                            Text(receita.descricao, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}