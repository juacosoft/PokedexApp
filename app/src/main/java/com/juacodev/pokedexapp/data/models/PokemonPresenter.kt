package com.juacodev.pokedexapp.data.models

import androidx.room.Entity

@Entity(tableName = "tbl_pokemons", primaryKeys = ["id"])
data class PokemonPresenter(
    val name:String,
    val image:String,
    val id:Int
)
