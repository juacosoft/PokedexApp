package com.juacodev.pokedexapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbl_pokemonde_ability")
data class PokemonAbilitiesModel(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")val id:Int,
    @SerializedName("ability") val ability:AbilityModel,
    @SerializedName("is_hidden")val isHiden:Boolean,
    @SerializedName("slot")val slot:Int
)

data class AbilityModel(
    @SerializedName("name")val abilityName:String,
    @SerializedName("url")val abilityUrl: String
    )
