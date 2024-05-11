package ktor.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class PokemonDetailDto(

	@SerialName("cries")
	val cries: Cries? = null,

	@SerialName("location_area_encounters")
	val locationAreaEncounters: String? = null,

	@SerialName("types")
	val types: List<TypesItem?>? = null,

	@SerialName("base_experience")
	val baseExperience: Int? = null,

	@SerialName("held_items")
	val heldItems: List<String?>? = null,

	@SerialName("weight")
	val weight: Int? = null,

	@SerialName("is_default")
	val isDefault: Boolean? = null,

	@SerialName("past_types")
	val pastTypes: List<String?>? = null,

	@SerialName("sprites")
	val sprites: Sprites? = null,

	@SerialName("past_abilities")
	val pastAbilities: List<String?>? = null,

	@SerialName("abilities")
	val abilities: List<AbilitiesItem?>? = null,

	@SerialName("game_indices")
	val gameIndices: List<GameIndicesItem?>? = null,

	@SerialName("species")
	val species: Species? = null,

	@SerialName("stats")
	val stats: List<StatsItem?>? = null,

	@SerialName("moves")
	val moves: List<MovesItem?>? = null,

	@SerialName("name")
	val name: String? = null,

	@SerialName("id")
	val id: Int? = null,

	@SerialName("forms")
	val forms: List<FormsItem?>? = null,

	@SerialName("height")
	val height: Int? = null,

	@SerialName("order")
	val order: Int? = null
)

@Serializable
data class HeartgoldSoulsilver(

	@SerialName("back_shiny_female")
	val backShinyFemale: String? = null,

	@SerialName("back_female")
	val backFemale: String? = null,

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_female")
	val frontFemale: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)

@Serializable
data class Icons(

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_female")
	val frontFemale: String? = null
)

@Serializable
data class Stat(

	@SerialName("name")
	val name: String? = null,

	@SerialName("url")
	val url: String? = null
)


@Serializable
data class DiamondPearl(

	@SerialName("back_shiny_female")
	val backShinyFemale: String? = null,

	@SerialName("back_female")
	val backFemale: String? = null,

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_female")
	val frontFemale: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)

@Serializable
data class Version(

	@SerialName("name")
	val name: String? = null,

	@SerialName("url")
	val url: String? = null
)

@Serializable
data class Other(

	@SerialName("dream_world")
	val dreamWorld: DreamWorld? = null,

	@SerialName("showdown")
	val showdown: Showdown? = null,

	@SerialName("official-artwork")
	val officialArtwork: OfficialArtwork? = null,

	@SerialName("home")
	val home: Home? = null
)

@Serializable
data class Silver(

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_transparent")
	val frontTransparent: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)

@Serializable
data class Home(

	@SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_female")
	val frontFemale: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)

@Serializable
data class Cries(

	@SerialName("legacy")
	val legacy: String? = null,

	@SerialName("latest")
	val latest: String? = null
)


@Serializable
data class XY(

	@SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_female")
	val frontFemale: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)


@Serializable
data class Sprites(

	@SerialName("back_shiny_female")
	val backShinyFemale: String? = null,

	@SerialName("back_female")
	val backFemale: String? = null,

	@SerialName("other")
	val other: Other? = null,

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("versions")
	val versions: Versions? = null,

	@SerialName("front_female")
	val frontFemale: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)


@Serializable
data class Yellow(

	@SerialName("front_gray")
	val frontGray: String? = null,

	@SerialName("back_transparent")
	val backTransparent: String? = null,

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("back_gray")
	val backGray: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_transparent")
	val frontTransparent: String? = null
)

@Serializable
data class RedBlue(

	@SerialName("front_gray")
	val frontGray: String? = null,

	@SerialName("back_transparent")
	val backTransparent: String? = null,

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("back_gray")
	val backGray: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_transparent")
	val frontTransparent: String? = null
)

@Serializable
data class GenerationVi(

	@SerialName("omegaruby-alphasapphire")
	val omegarubyAlphasapphire: OmegarubyAlphasapphire? = null,

	@SerialName("x-y")
	val xY: XY? = null
)

@Serializable
data class Gold(

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_transparent")
	val frontTransparent: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)

@Serializable
data class Showdown(

	@SerialName("back_shiny_female")
	val backShinyFemale: String? = null,

	@SerialName("back_female")
	val backFemale: String? = null,

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_female")
	val frontFemale: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)

@Serializable
data class DreamWorld(

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_female")
	val frontFemale: String? = null
)

@Serializable
data class GenerationViii(

	@SerialName("icons")
	val icons: Icons? = null
)

@Serializable
data class FormsItem(

	@SerialName("name")
	val name: String? = null,

	@SerialName("url")
	val url: String? = null
)

@Serializable
data class Emerald(

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)


@Serializable
data class UltraSunUltraMoon(

	@SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_female")
	val frontFemale: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)


@Serializable
data class Type(

	@SerialName("name")
	val name: String? = null,

	@SerialName("url")
	val url: String? = null
)

@Serializable
data class RubySapphire(

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)

@Serializable
data class OfficialArtwork(

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)

@Serializable
data class GenerationIi(

	@SerialName("gold")
	val gold: Gold? = null,

	@SerialName("crystal")
	val crystal: Crystal? = null,

	@SerialName("silver")
	val silver: Silver? = null
)

@Serializable
data class GenerationV(

	@SerialName("black-white")
	val blackWhite: BlackWhite? = null
)

@Serializable
data class VersionGroupDetailsItem(

	@SerialName("level_learned_at")
	val levelLearnedAt: Int? = null,

	@SerialName("version_group")
	val versionGroup: VersionGroup? = null,

	@SerialName("move_learn_method")
	val moveLearnMethod: MoveLearnMethod? = null
)


@Serializable
data class Versions(

	@SerialName("generation-iii")
	val generationIii: GenerationIii? = null,

	@SerialName("generation-ii")
	val generationIi: GenerationIi? = null,

	@SerialName("generation-v")
	val generationV: GenerationV? = null,

	@SerialName("generation-iv")
	val generationIv: GenerationIv? = null,

	@SerialName("generation-vii")
	val generationVii: GenerationVii? = null,

	@SerialName("generation-i")
	val generationI: GenerationI? = null,

	@SerialName("generation-viii")
	val generationViii: GenerationViii? = null,

	@SerialName("generation-vi")
	val generationVi: GenerationVi? = null
)

@Serializable
data class GenerationVii(

	@SerialName("icons")
	val icons: Icons? = null,

	@SerialName("ultra-sun-ultra-moon")
	val ultraSunUltraMoon: UltraSunUltraMoon? = null
)

@Serializable
data class Platinum(

	@SerialName("back_shiny_female")
	val backShinyFemale: String? = null,

	@SerialName("back_female")
	val backFemale: String? = null,

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_female")
	val frontFemale: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)

@Serializable
data class OmegarubyAlphasapphire(

	@SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_female")
	val frontFemale: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)


@Serializable
data class TypesItem(

	@SerialName("slot")
	val slot: Int? = null,

	@SerialName("type")
	val type: Type? = null
)


@Serializable
data class Crystal(

	@SerialName("back_transparent")
	val backTransparent: String? = null,

	@SerialName("back_shiny_transparent")
	val backShinyTransparent: String? = null,

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_transparent")
	val frontTransparent: String? = null,

	@SerialName("front_shiny_transparent")
	val frontShinyTransparent: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)


@Serializable
data class Species(

	@SerialName("name")
	val name: String? = null,

	@SerialName("url")
	val url: String? = null
)

@Serializable
data class FireredLeafgreen(

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)


@Serializable
data class MoveLearnMethod(

	@SerialName("name")
	val name: String? = null,

	@SerialName("url")
	val url: String? = null
)


@Serializable
data class GenerationI(

	@SerialName("yellow")
	val yellow: Yellow? = null,

	@SerialName("red-blue")
	val redBlue: RedBlue? = null
)


@Serializable
data class VersionGroup(

	@SerialName("name")
	val name: String? = null,

	@SerialName("url")
	val url: String? = null
)


@Serializable
data class GameIndicesItem(

	@SerialName("game_index")
	val gameIndex: Int? = null,

	@SerialName("version")
	val version: Version? = null
)


@Serializable
data class GenerationIii(

	@SerialName("firered-leafgreen")
	val fireredLeafgreen: FireredLeafgreen? = null,

	@SerialName("ruby-sapphire")
	val rubySapphire: RubySapphire? = null,

	@SerialName("emerald")
	val emerald: Emerald? = null
)


@Serializable
data class AbilitiesItem(

	@SerialName("is_hidden")
	val isHidden: Boolean? = null,

	@SerialName("ability")
	val ability: Ability? = null,

	@SerialName("slot")
	val slot: Int? = null
)

@Serializable
data class MovesItem(

	@SerialName("version_group_details")
	val versionGroupDetails: List<VersionGroupDetailsItem?>? = null,

	@SerialName("move")
	val move: Move? = null
)

@Serializable
data class Ability(

	@SerialName("name")
	val name: String? = null,

	@SerialName("url")
	val url: String? = null
)


@Serializable
data class BlackWhite(

	@SerialName("back_shiny_female")
	val backShinyFemale: String? = null,

	@SerialName("back_female")
	val backFemale: String? = null,

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("animated")
	val animated: Animated? = null,

	@SerialName("front_female")
	val frontFemale: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)


@Serializable
data class Move(

	@SerialName("name")
	val name: String? = null,

	@SerialName("url")
	val url: String? = null
)


@Serializable
data class GenerationIv(

	@SerialName("platinum")
	val platinum: Platinum? = null,

	@SerialName("diamond-pearl")
	val diamondPearl: DiamondPearl? = null,

	@SerialName("heartgold-soulsilver")
	val heartgoldSoulsilver: HeartgoldSoulsilver? = null
)


@Serializable
data class Animated(

	@SerialName("back_shiny_female")
	val backShinyFemale: String? = null,

	@SerialName("back_female")
	val backFemale: String? = null,

	@SerialName("back_default")
	val backDefault: String? = null,

	@SerialName("front_shiny_female")
	val frontShinyFemale: String? = null,

	@SerialName("front_default")
	val frontDefault: String? = null,

	@SerialName("front_female")
	val frontFemale: String? = null,

	@SerialName("back_shiny")
	val backShiny: String? = null,

	@SerialName("front_shiny")
	val frontShiny: String? = null
)


@Serializable
data class StatsItem(

	@SerialName("stat")
	val stat: Stat? = null,

	@SerialName("base_stat")
	val baseStat: Int? = null,

	@SerialName("effort")
	val effort: Int? = null
)
