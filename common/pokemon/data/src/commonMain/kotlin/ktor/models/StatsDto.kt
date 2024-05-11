package ktor.models

import kotlinx.serialization.Serializable


@Serializable
data class StatsDto(
    val list: List<Pair<String, Int>>
)