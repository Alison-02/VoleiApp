package com.example.appvoleitimes.logic

data class Player(
    val name: String,
    val skills: Map<String, Int>,
    val gamesPlayed: Int,
    val avoidWith: List<String>
)

data class Team(val players: List<Player>, val totalSkill: Int)

fun sortTeams(
    players: List<Player>,
    considerPositions: Boolean,
    considerGamesPlayed: Boolean,
    avoidPairs: Boolean,
    numTeams: Int = 2
): List<Team> {
    // Filtrar apenas jogadores selecionados
    val eligiblePlayers = players.sortedBy { if (considerGamesPlayed) it.gamesPlayed else 0 }

    // Divisão inicial
    val teams = MutableList(numTeams) { mutableListOf<Player>() }

    eligiblePlayers.forEach { player ->
        val targetTeam = teams.minByOrNull { calculateTeamSkill(it, considerPositions) } ?: teams.first()
        if (avoidPairs && isAvoided(player, targetTeam)) {
            val alternativeTeam = teams.first { !isAvoided(player, it) }
            alternativeTeam.add(player)
        } else {
            targetTeam.add(player)
        }
    }

    return teams.map { team ->
        Team(team, calculateTeamSkill(team, considerPositions))
    }
}

private fun calculateTeamSkill(team: List<Player>, considerPositions: Boolean): Int {
    return if (considerPositions) {
        team.sumOf { it.skills.values.sum() }
    } else {
        team.sumOf { it.skills.values.average().toInt() }
    }
}

private fun isAvoided(player: Player, team: List<Player>): Boolean {
    return team.any { it.name in player.avoidWith }
}
