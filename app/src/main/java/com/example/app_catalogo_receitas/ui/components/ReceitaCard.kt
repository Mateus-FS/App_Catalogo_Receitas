package com.example.app_catalogo_receitas.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.app_catalogo_receitas.model.Receita

@Composable
fun ReceitaCard(
    receita: Receita,
    favorita: Boolean,
    onClick: () -> Unit,
    onToggleFavorito: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 0 significa "sem imagem": evita crash do painterResource
            if (receita.imagem != 0) {
                Image(
                    painter = painterResource(id = receita.imagem),
                    contentDescription = receita.titulo,
                    modifier = Modifier.size(72.dp)
                )
                Spacer(Modifier.width(12.dp))
            }

            Column(modifier = Modifier.weight(1f)) {
                Text(receita.titulo, style = MaterialTheme.typography.titleMedium)
                Text(receita.descricao, style = MaterialTheme.typography.bodyMedium)
            }

            IconButton(onClick = onToggleFavorito) {
                Icon(
                    imageVector = if (favorita) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription = if (favorita) "Remover dos favoritos" else "Adicionar aos favoritos",
                    tint = if (favorita) MaterialTheme.colorScheme.error else LocalContentColor.current
                )
            }
        }
    }
}