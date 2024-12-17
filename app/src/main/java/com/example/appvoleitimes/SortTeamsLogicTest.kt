package com.example.appvoleitimes.logic

import org.junit.Test
import org.junit.Assert.assertEquals


class SortTeamsLogicTest {

    @Test
    fun testSortTeams() {
        val players = listOf(
            Player("Jogador 1", mapOf("Pos1" to 5, "Pos2" to 7), 0, listOf("Jogador 4")),
            Player("Jogador 2", mapOf("Pos1" to 8, "Pos2" to 6), 1, emptyList()),
            Player("Jogador 3", mapOf("Pos1" to 6, "Pos2" to 9), 0, emptyList()),
            Player("Jogador 4", mapOf("Pos1" to 5, "Pos2" to 8), 3, listOf("Jogador 1")),
            Player("Jogador 5", mapOf("Pos1" to 7, "Pos2" to 7), 2, emptyList()),
            Player("Jogador 6", mapOf("Pos1" to 8, "Pos2" to 5), 1, emptyList())
        )

        val sortedTeams = sortTeams(
            players,
            considerPositions = true,
            considerGamesPlayed = true,
            avoidPairs = true
        )

        println(sortedTeams)
        assert(sortedTeams.size == 2) // Verifica se os times foram criados corretamente
    }
}
