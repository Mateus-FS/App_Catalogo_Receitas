package com.example.app_catalogo_receitas.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Receita(
    val id: Int,
    val titulo: String,
    val descricao: String,
    val ingredientes: List<String>,
    val passos: List<String>,
    val categoria: Categoria,
    val tempo: String = "",
    val dificuldade: String = "",
    val porcoes: Int = 0
) : Parcelable