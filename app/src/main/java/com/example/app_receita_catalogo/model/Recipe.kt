package com.example.app_receita_catalogo.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val id: Int,
    val titulo: String,
    val descricao: String,
    val ingredientes: List<String>,
    val passos: List<String>,
    @DrawableRes val imagem: Int,
    val favorito: Boolean = false
) : Parcelable