package com.example.appvoleitimes.viewmodel

import androidx.lifecycle.ViewModel
import com.example.appvoleitimes.logic.Player
import com.example.appvoleitimes.logic.Team
import com.example.appvoleitimes.logic.sortTeams
import com.example.appvoleitimes.utils.JsonUtils

class SortTeamsViewModel : ViewModel() {
    private val players = mutableListOf<Player>()

    // Função para adicionar jogador
    fun addPlayer(player: Player) {
        players.add(player)
    }

    // Função para carregar os jogadores salvos
    fun loadPlayers(context: Context) {
        val loadedPlayers = JsonUtils.loadPlayersData(context)
        loadedPlayers?.let {
            players.clear()
            players.addAll(it)
        }
    }

    // Função para salvar os jogadores
    fun savePlayers(context: Context) {
        JsonUtils.savePlayersData(context, players)
    }

    // Função para ordenar os times
    fun sortTeams(
        considerPositions: Boolean,
        considerGamesPlayed: Boolean,
        avoidPairs: Boolean
    ): List<Team> {
        return sortTeams(players, considerPositions, considerGamesPlayed, avoidPairs)
    }
}
