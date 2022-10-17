package com.juacodev.pokedexapp.domain


import com.juacodev.pokedexapp.data.local.PokedexDao
import com.juacodev.pokedexapp.data.local.PokedexLocalRepository
import com.juacodev.pokedexapp.data.models.PokemonPresenter
import com.juacodev.pokedexapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class PokemonListLocalUseCase @Inject constructor(
    private val localRepository: PokedexLocalRepository
) {
    suspend fun getPokemonListLocal():
            Flow<Resource<List<PokemonPresenter>>> = localRepository.getAllPokemons()

}