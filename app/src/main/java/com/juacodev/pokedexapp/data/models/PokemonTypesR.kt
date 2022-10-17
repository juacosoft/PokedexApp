package com.juacodev.pokedexapp.data.models

import com.google.gson.annotations.SerializedName

data class PokemonTypesR(
    @SerializedName("slot")val slot:Int,
    @SerializedName("type")val type:pokemonTypeModelR
)
data class pokemonTypeModelR(
    @SerializedName("name")val name:String,
    @SerializedName("url")val url:String
)
