package com.juacodev.pokedexapp.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.juacodev.pokedexapp.data.models.PokemonModelR

class ObjectConverters {
    @TypeConverter
    fun genrelistToJson(value:List<PokemonModelR>?)= Gson().toJson(value)

    @TypeConverter
    fun jsonToListgenre(value:String)= Gson().fromJson(value,Array<PokemonModelR>::class.java).toList()
}