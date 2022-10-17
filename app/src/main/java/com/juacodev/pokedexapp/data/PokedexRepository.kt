package com.juacodev.pokedexapp.data

import android.util.Log
import com.juacodev.pokedexapp.data.local.PokedexDao
import com.juacodev.pokedexapp.data.network.PokedexRemoteService
import com.juacodev.pokedexapp.util.Resource
import com.juacodev.pokedexapp.util.networkBoundResource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class PokedexRepository @Inject constructor(
    private val api: PokedexRemoteService,
    private val local:PokedexDao
) {
    fun getPokemonLocalRemote(limit:Int,offset:Int) = networkBoundResource(
        query = {
            local.getAllPokemonsFlow()
        }, fetch = {
            delay(2000)
            api.getPokemonList(limit,offset)
        },
        saveFetchResult = {pokemons->
            local.insertAllPokemon(pokemons)
        }

    )
    fun getRemotePokemonDetails(id: Int)= flow {
        emit(Resource.Loading())
        try {
            val response = api.getPokemonDetail(id)
            local.insertPokemonDetails(response.toLocalPresenter())
            emit(Resource.Success(response))
        }catch (e:Exception){
            emit(Resource.Error(e))
        }
    }
}