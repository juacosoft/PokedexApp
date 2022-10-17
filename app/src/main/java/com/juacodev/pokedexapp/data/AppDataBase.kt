package com.juacodev.pokedexapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.juacodev.pokedexapp.data.local.PokedexDao
import com.juacodev.pokedexapp.data.models.PokemonModelR
import com.juacodev.pokedexapp.data.models.PokemonPresenter

@Database(entities = [PokemonPresenter::class], version = 1, exportSchema = false)
@TypeConverters(ObjectConverters::class)
abstract class AppDataBase :RoomDatabase() {
    abstract fun pokedexDao(): PokedexDao
}