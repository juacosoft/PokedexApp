package com.juacodev.pokedexapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.juacodev.pokedexapp.data.models.*
import kotlinx.coroutines.flow.Flow


@Dao
interface PokedexDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllPokemon(pokemon: List<PokemonPresenter>)

    @Query("SELECT * FROM tbl_pokemons")
    suspend fun getAllPokemons(): List<PokemonPresenter>

    @Query("SELECT * FROM tbl_pokemons")
    fun getAllPokemonsFlow(): Flow<List<PokemonPresenter>>


    @Query("SELECT * FROM tbl_pokemons WHERE name LIKE '%' || :query || '%'")
    fun getPokemonById(query:String):Flow<PokemonPresenter>

    @Query("SELECT * FROM tbl_pokemondetails WHERE id LIKE '%' || :query || '%'")
    suspend fun getPokemonDetails(query:Int):PokemonDetailPresenter

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonDetails(pokemon: PokemonDetailPresenter)

}