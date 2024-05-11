package models

data class PokemonAboutInfo(
    val name:String,
    val species:String?,
    val height:Float?,
    val weight:Float?,
    val types:List<String>,
    val abilities:List<String>,
    val hp:Int?,
    val atk:Int?,
    val def:Int?,
    val spAtk:Int?,
    val spDef:Int?,
    val spd:Int?
)