package com.juacodev.pokedexapp.data.network

import com.juacodev.pokedexapp.data.models.*
import com.juacodev.pokedexapp.util.END_POINT_GET_POKEMON
import com.juacodev.pokedexapp.util.END_POINT_GET_POKEMONS
import com.juacodev.pokedexapp.util.END_POINT_GET_TYPE
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexApi {
    @GET(END_POINT_GET_POKEMONS)
    suspend fun getListPokemon(
        @Query("limit") limit:Int,
        @Query("offset") offset:Int,
    ): Response<ResponsePokemonList>

    @GET(END_POINT_GET_POKEMON)
    suspend fun getPokemonById(
        @Path("id")id:Int
    ):Response<PokemonDetailR>

    @GET(END_POINT_GET_TYPE)
    suspend fun getTypeById(
        @Path("id")id:Int
    ):Response<PokemonTypeR>

}