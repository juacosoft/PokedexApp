package com.juacodev.pokedexapp.domain

import com.juacodev.pokedexapp.data.PokedexRepository
import com.juacodev.pokedexapp.data.local.PokedexLocalRepository
import com.juacodev.pokedexapp.data.models.PokemonDetailR
import com.juacodev.pokedexapp.data.models.PokemonPresenter
import com.juacodev.pokedexapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonDetailLocalUseCase @Inject constructor(
    private val repository: PokedexLocalRepository
) {
   suspend fun getPokemonDetail(id:Int): Flow<Resource<PokemonDetailR>>
           = repository.getPokemonDetail(id)

}