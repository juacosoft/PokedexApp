package com.juacodev.pokedexapp.data.models

import com.google.gson.annotations.SerializedName


data class PokemonAbilitiesModel(
    @SerializedName("ability") val ability:AbilityModel,
    @SerializedName("is_hidden")val isHiden:Boolean,
    @SerializedName("slot")val slot:Int
)

data class AbilityModel(
    @SerializedName("name")val abilityName:String,
    @SerializedName("url")val abilityUrl: String
    )
