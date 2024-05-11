package ktor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PokemonListDto(

	@SerialName("next")
	val next: String? = null,

	@SerialName("previous")
	val previous: String? = null,

	@SerialName("count")
	val count: Int? = null,

	@SerialName("results")
	val results: List<ResultsItem?>? = null
)

@Serializable
data class ResultsItem(

	@SerialName("name")
	val name: String? = null,

	@SerialName("url")
	val url: String? = null
)
