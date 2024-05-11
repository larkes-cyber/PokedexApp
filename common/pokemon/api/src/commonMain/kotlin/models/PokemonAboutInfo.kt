package models

data class PokemonAboutInfo(
    val name:String,
    val species:String?,
    val height:Int?,
    val weight:Int?,
    val types:List<String>,
    val abilities:List<String>,
    val stat:List<Pair<String, Int>>
)