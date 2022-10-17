package com.juacodev.pokedexapp.data.models

import com.google.gson.annotations.SerializedName
import com.juacodev.pokedexapp.util.IMAGE_URL

data class PokemonModelR(
    @SerializedName("name") val pokemonName:String,
    @SerializedName("url") val url:String,
){
    fun tolocalPresenter():PokemonPresenter{
        val id = url.split("/")[6].toInt()
        val image= "$IMAGE_URL$id.png"
        return PokemonPresenter(pokemonName,image,id)
    }
}

