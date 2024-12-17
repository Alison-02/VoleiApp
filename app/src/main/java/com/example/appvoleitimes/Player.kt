package com.example.appvoleitimes

data class Player(
    val name: String,
    val skills: Map<String, Int>,  // Habilidades do jogador (por posição)
    val gamesPlayed: Int,          // Número de vezes jogadas
    val avoidWith: List<String>    // Lista de jogadores para evitar no mesmo time
)
