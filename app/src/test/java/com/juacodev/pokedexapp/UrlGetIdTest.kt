package com.juacodev.pokedexapp

import org.junit.After
import org.junit.Test

class UrlGetIdTest {

    var pokemonUrl="https://pokeapi.co/api/v2/pokemon/1/"

    @Test
    fun `get id from url`() {
        val id = pokemonUrl.split("/")[6]
        assert(id == "1")
    }

}