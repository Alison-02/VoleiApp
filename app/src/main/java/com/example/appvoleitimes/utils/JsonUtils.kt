package com.example.appvoleitimes.utils

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.lang.reflect.Type

object JsonUtils {
    private const val FILE_NAME = "players_data.json"

    // Função para salvar a lista de jogadores em JSON
    fun savePlayersData(context: Context, players: List<Player>) {
        val gson = Gson()
        val json = gson.toJson(players)

        val file = File(context.filesDir, FILE_NAME)
        file.writeText(json)
    }

    // Função para carregar a lista de jogadores a partir do JSON
    fun loadPlayersData(context: Context): List<Player>? {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) return null

        val json = file.readText()
        val gson = Gson()
        val type: Type = object : TypeToken<List<Player>>() {}.type
        return gson.fromJson(json, type)
    }
}
