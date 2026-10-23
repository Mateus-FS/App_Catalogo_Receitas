package com.example.app_catalogo_receitas.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "favoritos")

class FavoritosStore(private val context: Context) {

    private val chave = stringSetPreferencesKey("favoritos_ids")

    /** IDs das receitas favoritas; emite de novo a cada mudança. */
    val favoritos: Flow<Set<Int>> = context.dataStore.data.map { prefs ->
        prefs[chave].orEmpty().mapNotNull { it.toIntOrNull() }.toSet()
    }

    /** Adiciona o ID se não estiver salvo, remove se já estiver. */
    suspend fun alternar(id: Int) {
        context.dataStore.edit { prefs ->
            val atual = prefs[chave].orEmpty()
            val texto = id.toString()
            prefs[chave] = if (texto in atual) atual - texto else atual + texto
        }
    }
}