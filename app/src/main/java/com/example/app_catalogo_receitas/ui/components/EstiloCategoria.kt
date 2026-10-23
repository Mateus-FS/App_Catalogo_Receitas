package com.example.app_catalogo_receitas.ui.components

import androidx.compose.ui.graphics.Color
import com.example.app_catalogo_receitas.model.Categoria

/** Cor de fundo e emoji que representam cada categoria de receita. */
data class EstiloCategoria(val fundo: Color, val emoji: String)

fun estiloDaCategoria(categoria: Categoria): EstiloCategoria = when (categoria) {
    Categoria.MASSAS -> EstiloCategoria(Color(0xFFF3D6C6), "🍝")
    Categoria.DOCES -> EstiloCategoria(Color(0xFFF6E3A9), "🍰")
    Categoria.SALADAS -> EstiloCategoria(Color(0xFFD6E7CB), "🥗")
    Categoria.PRATOS_PRINCIPAIS -> EstiloCategoria(Color(0xFFF2D0C8), "🍲")
    Categoria.CAFE_DA_MANHA -> EstiloCategoria(Color(0xFFEFE6D6), "🥞")
}