package com.example.app_catalogo_receitas.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app_catalogo_receitas.R
import com.example.app_catalogo_receitas.model.Receita
import com.example.app_catalogo_receitas.ui.theme.AppCatalogoReceitaTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalhesReceitaScreen(
    receita: Receita,
    onVoltar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = "Detalhes") },
                navigationIcon = {
                    IconButton(onClick = onVoltar) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Voltar"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            if (receita.imagem != 0) {
                Image(
                    painter = painterResource(id = receita.imagem),
                    contentDescription = receita.titulo,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                )
            }

            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = receita.titulo,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(
                    text = receita.descricao,
                    style = MaterialTheme.typography.bodyLarge
                )

                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                Text(
                    text = "Ingredientes",
                    style = MaterialTheme.typography.titleLarge
                )
                receita.ingredientes.forEach { ingrediente ->
                    Text(
                        text = "• $ingrediente",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                Text(
                    text = "Modo de preparo",
                    style = MaterialTheme.typography.titleLarge
                )
                receita.passos.forEachIndexed { indice, passo ->
                    Text(
                        text = "${indice + 1}. $passo",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetalhesReceitaScreenPreview() {
    AppCatalogoReceitaTheme {
        DetalhesReceitaScreen(
            receita = Receita(
                id = 1,
                titulo = "Bolo de Cenoura",
                descricao = "Bolo fofinho de cenoura com cobertura de chocolate.",
                ingredientes = listOf(
                    "3 cenouras médias",
                    "4 ovos",
                    "1 xícara de óleo",
                    "2 xícaras de açúcar",
                    "2 xícaras de farinha de trigo"
                ),
                passos = listOf(
                    "Bata no liquidificador as cenouras, os ovos e o óleo.",
                    "Misture com o açúcar e a farinha.",
                    "Asse em forno médio por 40 minutos."
                ),
                imagem = R.drawable.ic_launcher_foreground
            ),
            onVoltar = {}
        )
    }
}