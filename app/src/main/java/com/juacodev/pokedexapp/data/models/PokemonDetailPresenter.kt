package com.juacodev.pokedexapp.data.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tbl_pokemondetails", primaryKeys = ["id"])
data class PokemonDetailPresenter (
    @SerializedName("id")val id:Int,
    @SerializedName("name")val name:String,
    @SerializedName("base_experience")val baseExperience:Int,
    @SerializedName("height")val height:Int,
    @SerializedName("weight")val weight:Int,
    @SerializedName("is_default")val isDefault:Boolean,
){
    fun toRemoteSync():PokemonDetailR{
        return PokemonDetailR(id,name,baseExperience,height,weight,isDefault)
    }
}