package com.juacodev.pokedexapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.juacodev.pokedexapp.data.models.PokemonModelR
import com.juacodev.pokedexapp.data.models.PokemonPresenter
import kotlinx.coroutines.flow.Flow


@Dao
interface PokedexDao {
    @Query("SELECT * FROM tbl_pokemons")
    suspend fun getAllPokemons(): List<PokemonPresenter>

    @Query("SELECT * FROM tbl_pokemons")
    fun getAllPokemonsFlow(): Flow<List<PokemonPresenter>>

    @Query("SELECT * FROM tbl_pokemons WHERE name LIKE '%' || :query || '%'")
    fun getPokemonById(query:String):Flow<PokemonPresenter>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemon: PokemonPresenter)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemon(pokemon: List<PokemonPresenter>)
}