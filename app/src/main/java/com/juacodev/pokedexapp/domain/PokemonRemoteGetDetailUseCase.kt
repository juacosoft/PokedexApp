package com.juacodev.pokedexapp.domain

import com.juacodev.pokedexapp.data.PokedexRepository
import com.juacodev.pokedexapp.data.models.PokemonDetailR
import com.juacodev.pokedexapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRemoteGetDetailUseCase @Inject constructor(
    private val repository: PokedexRepository
) {
    fun getPokemonDetail(id:Int): Flow<Resource<PokemonDetailR>> = repository.getRemotePokemonDetails(id)

}