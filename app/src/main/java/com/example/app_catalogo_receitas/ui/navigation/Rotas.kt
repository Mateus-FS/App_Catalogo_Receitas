package com.example.app_catalogo_receitas.ui.navigation

object Rotas {
    const val LISTA = "lista"
    const val FAVORITAS = "favoritas"
    const val DETALHE = "detalhe/{id}"

    fun detalhe(id: Int) = "detalhe/$id"
}