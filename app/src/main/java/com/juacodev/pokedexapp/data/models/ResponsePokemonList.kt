package com.juacodev.pokedexapp.data.models

import com.google.gson.annotations.SerializedName

data class ResponsePokemonList(
    @SerializedName("count")val count:Int,
    @SerializedName("next")val next:String?,
    @SerializedName("previous") val previous:String?,
    @SerializedName("results") val results:List<PokemonModelR>
)
