package com.juacodev.pokedexapp.data

import android.util.Log
import com.juacodev.pokedexapp.data.local.PokedexDao
import com.juacodev.pokedexapp.data.network.PokedexRemoteService
import com.juacodev.pokedexapp.util.networkBoundResource
import kotlinx.coroutines.delay
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
    fun getPokemonLocalRemote(id:Int) = networkBoundResource(
        query = {
            local.getPokemonById(id.toString())
        }, fetch = {
            delay(2000)
            api.getPokemonDetail(id)
        },
        saveFetchResult = {pokemon->
            local.insertPokemon(pokemon)
        }

    )
}