package com.juacodev.pokedexapp.data.network

import android.util.Log
import com.juacodev.pokedexapp.data.models.PokemonDetailR
import com.juacodev.pokedexapp.data.models.PokemonModelR
import com.juacodev.pokedexapp.data.models.PokemonPresenter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokedexRemoteService @Inject constructor(
    private val pokedexApi: PokedexApi
) {
    suspend fun getPokemonList(
        limit:Int,offset:Int
    ):List<PokemonPresenter>{
        return withContext(Dispatchers.IO){
            val response = pokedexApi.getListPokemon(limit,offset)
            response.body().let {
                it?.results?.map { pokemon ->
                    pokemon.tolocalPresenter()
                } ?: emptyList()
            }
        }
    }
    suspend fun getPokemonDetail(
        id:Int
    ):PokemonDetailR{
        return withContext(Dispatchers.IO){
            val response = pokedexApi.getPokemonById(id)
            response.body()!!
        }
    }

}