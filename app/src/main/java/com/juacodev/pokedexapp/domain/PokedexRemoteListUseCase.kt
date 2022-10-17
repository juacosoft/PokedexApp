package com.juacodev.pokedexapp.domain


import com.juacodev.pokedexapp.data.PokedexRepository
import com.juacodev.pokedexapp.data.models.PokemonModelR
import com.juacodev.pokedexapp.data.models.PokemonPresenter
import com.juacodev.pokedexapp.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokedexRemoteListUseCase @Inject constructor(
    private val repository: PokedexRepository
) {
    fun getPokemonListRemote(limit:Int,offset:Int): Flow<Resource<List<PokemonPresenter>>> = repository.getPokemonLocalRemote(limit,offset)

}
