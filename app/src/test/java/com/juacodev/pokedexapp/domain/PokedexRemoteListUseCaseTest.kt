package com.juacodev.pokedexapp.domain

import com.juacodev.pokedexapp.data.PokedexRepository
import com.juacodev.pokedexapp.data.local.PokedexDao
import com.juacodev.pokedexapp.data.network.PokedexApi
import com.juacodev.pokedexapp.data.network.PokedexRemoteService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import com.juacodev.pokedexapp.util.Resource
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

@ExperimentalCoroutinesApi
class  PokedexRemoteListUseCaseTest{
    private val api= Mockito.mock(PokedexApi::class.java)
    private val local= Mockito.mock(PokedexDao::class.java)
    private val remoteService= PokedexRemoteService(api)
    private lateinit var repository: PokedexRepository
    private lateinit var useCase: PokedexRemoteListUseCase

    @Before
    fun setup(){
        repository=PokedexRepository(remoteService,local)
        useCase=PokedexRemoteListUseCase(repository)
    }
    @Test
    fun `get pokemon list from use case flow`()= runTest{
        val result=useCase.getPokemonListRemote(20,0)
        result.map {
            assert(it is Resource.Error)
        }
    }
}