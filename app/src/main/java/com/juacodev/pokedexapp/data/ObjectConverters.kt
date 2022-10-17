package com.juacodev.pokedexapp.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.juacodev.pokedexapp.data.models.AbilityModel
import com.juacodev.pokedexapp.data.models.PokemonAbilitiesModel
import com.juacodev.pokedexapp.data.models.PokemonDetailR
import com.juacodev.pokedexapp.data.models.PokemonModelR

class ObjectConverters {
    @TypeConverter
    fun genrelistToJson(value:List<PokemonModelR>?)= Gson().toJson(value)

    @TypeConverter
    fun jsonToListgenre(value:String)= Gson().fromJson(value,Array<PokemonModelR>::class.java).toList()

    @TypeConverter
    fun jsonToPokemonDetail(value:String)= Gson().fromJson(value,PokemonDetailR::class.java)

    @TypeConverter
    fun jsonToPokemonTypeAbility(value:String)= Gson().fromJson(value, PokemonAbilitiesModel::class.java)
    @TypeConverter
    fun toJsonPokemonListTypeAbility(value:List<PokemonAbilitiesModel>?)= Gson().toJson(value)


    @TypeConverter
    fun toAbilitiesarray(value:List<AbilityModel>?)= Gson().toJson(value)

    @TypeConverter
    fun toAbilitiesarray(value:String)= Gson().fromJson(value,Array<AbilityModel>::class.java).toList()
}