package com.juacodev.pokedexapp.data.local

import com.juacodev.pokedexapp.data.models.PokemonDetailR
import com.juacodev.pokedexapp.data.models.PokemonPresenter
import com.juacodev.pokedexapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokedexLocalRepository @Inject constructor(
    val local:PokedexDao
) {
    suspend fun getAllPokemons(): Flow<Resource<List<PokemonPresenter>>> = flow {
        emit(Resource.Loading())
        try {
            val pokemons = local.getAllPokemons()
            emit(Resource.Success(pokemons))
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
    suspend fun getPokemonDetail(id:Int):Flow<Resource<PokemonDetailR>> = flow {
        emit(Resource.Loading())
        try {
            val pokemon = local.getPokemonDetails(id)

            emit(Resource.Success(pokemon.toRemoteSync()))
        } catch (e: Exception) {
            emit(Resource.Error(e))
        }
    }
}