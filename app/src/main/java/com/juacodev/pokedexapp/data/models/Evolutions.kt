package com.juacodev.pokedexapp.data.models

import com.google.gson.annotations.SerializedName

data class Evolutions(
    @SerializedName("id")val id:Int,
    @SerializedName("name")val name:String,
    @SerializedName("pokemon_species")val pokemonSpecies:PokemonModelR,
)
