package com.example.app_catalogo_receitas.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_catalogo_receitas.model.Categoria

/** Quadrado arredondado e colorido com o emoji da categoria (usado nos cards). */
@Composable
fun MiniaturaReceita(
    categoria: Categoria,
    modifier: Modifier = Modifier,
    tamanho: Dp = 76.dp
) {
    val estilo = estiloDaCategoria(categoria)
    Box(
        modifier = modifier
            .size(tamanho)
            .clip(RoundedCornerShape(16.dp))
            .background(estilo.fundo),
        contentAlignment = Alignment.Center
    ) {
        Text(text = estilo.emoji, fontSize = 34.sp)
    }
}