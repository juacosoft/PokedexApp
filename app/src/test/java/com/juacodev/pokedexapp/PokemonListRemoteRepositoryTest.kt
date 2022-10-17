package com.juacodev.pokedexapp

import com.juacodev.pokedexapp.data.PokedexRepository
import com.juacodev.pokedexapp.data.local.PokedexDao
import com.juacodev.pokedexapp.data.network.PokedexApi
import com.juacodev.pokedexapp.data.network.PokedexRemoteService
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.map
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class PokemonListRemoteRepositoryTest {
    private val api=mock(PokedexApi::class.java)
    private val local= mock(PokedexDao::class.java)
    private val remoteService= PokedexRemoteService(api)
    private lateinit var repository:PokedexRepository
    @Before
    fun setup(){
        repository=PokedexRepository(remoteService,local)
    }
    @Test
    fun `get pokemon list from remote`(){
        val limit=20
        val offset=0
        val result=repository.getPokemonLocalRemote(limit,offset)
        result.map {
            assert(it.data?.size==20)
        }
    }
}