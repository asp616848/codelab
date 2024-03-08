package com.example.dessertrelease.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import java.util.prefs.Preferences

class UserPreferencesRepository(private val dataStore: DataStore<Preferences>) {
    private companion object{
        val IS_LINEAR_LAYOUT = booleanPreferencesKey("is_linear_layout")
    }
}