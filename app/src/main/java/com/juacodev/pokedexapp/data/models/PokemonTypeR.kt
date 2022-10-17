package com.juacodev.pokedexapp.data.models

import com.google.gson.annotations.SerializedName

data class PokemonTypeR(
    @SerializedName("name")val name:String,
    @SerializedName("id")val id:Int,
    @SerializedName("moves")val moves:List<Moves>,
    @SerializedName("move_damage_class")val moveDamageClass:MoveDamageClass,

)
data class Moves(
    @SerializedName("name")val name:String,
    @SerializedName("url")val url:String
)
data class MoveDamageClass(
    @SerializedName("name")val name:String,
    @SerializedName("url")val url:String
)
