package com.example.app_catalogo_receitas.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_catalogo_receitas.data.FavoritosStore
import com.example.app_catalogo_receitas.data.ReceitasDataSource
import com.example.app_catalogo_receitas.model.Receita
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.Collator
import java.util.Locale

class ReceitasViewModel(application: Application) : AndroidViewModel(application) {

    private val store = FavoritosStore(application)

    private val collator = Collator.getInstance(Locale.forLanguageTag("pt-BR"))

    val receitas: List<Receita> = ReceitasDataSource.receitas
        .sortedWith { a, b -> collator.compare(a.titulo, b.titulo) }

    val favoritos: StateFlow<Set<Int>> = store.favoritos.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = emptySet()
    )

    fun alternarFavorito(receita: Receita) {
        viewModelScope.launch { store.alternar(receita.id) }
    }

    fun receitaPorId(id: Int): Receita? = ReceitasDataSource.porId(id)

    fun receitasFavoritas(favoritos: Set<Int>): List<Receita> =
        receitas.filter { it.id in favoritos }
}