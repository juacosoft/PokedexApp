package com.juacodev.pokedexapp

import com.juacodev.pokedexapp.data.PokedexRepository
import com.juacodev.pokedexapp.data.local.PokedexDao
import com.juacodev.pokedexapp.data.network.PokedexApi
import com.juacodev.pokedexapp.data.network.PokedexRemoteService
import kotlinx.coroutines.flow.map
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class RemotePokemonDetailRepositoryTest {
    private val api= Mockito.mock(PokedexApi::class.java)
    private val local= Mockito.mock(PokedexDao::class.java)
    private val remoteService= PokedexRemoteService(api)
    private lateinit var repository: PokedexRepository
    @Before
    fun setup(){
        repository=PokedexRepository(remoteService,local)
    }
    @Test
    fun `get pokemon detail from remote`(){
        val id=1
        val result=repository.getRemotePokemonDetails(id)
        result.map {
            assertEquals(it.data?.name,"bulbasaur")
        }
    }

}