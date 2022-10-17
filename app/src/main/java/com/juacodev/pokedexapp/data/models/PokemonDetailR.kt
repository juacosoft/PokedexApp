package com.juacodev.pokedexapp.data.models



import com.google.gson.annotations.SerializedName

data class PokemonDetailR(
    @SerializedName("id")val id:Int,
    @SerializedName("name")val name:String,
    @SerializedName("base_experience")val baseExperience:Int,
    @SerializedName("height")val height:Int,
    @SerializedName("weight")val weight:Int,
    @SerializedName("is_default")val isDefault:Boolean,

){
    fun toLocalPresenter():PokemonDetailPresenter{
        return PokemonDetailPresenter(id,name,baseExperience,height,weight,isDefault)
    }
}

