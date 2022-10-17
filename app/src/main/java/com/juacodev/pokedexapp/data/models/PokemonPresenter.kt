package com.juacodev.pokedexapp.data.models

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tbl_pokemons", primaryKeys = ["id"])
data class PokemonPresenter(
    val name:String,
    val image:String,
    val id:Int
):Parcelable
