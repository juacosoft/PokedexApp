package com.juacodev.pokedexapp.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juacodev.pokedexapp.data.models.PokemonDetailR
import com.juacodev.pokedexapp.domain.PokemonDetailLocalUseCase
import com.juacodev.pokedexapp.domain.PokemonRemoteGetDetailUseCase
import com.juacodev.pokedexapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsPokemonViewModel @Inject constructor(
    private val pokemonGetDetailUseCase: PokemonRemoteGetDetailUseCase,
    private val localUseCase: PokemonDetailLocalUseCase
) : ViewModel() {
    private val _pokemonDetailListLD: MutableLiveData<Resource<PokemonDetailR>> =
        MutableLiveData()
    val pokemonDetailListLD get() = _pokemonDetailListLD

    fun syncList(id:Int){
        viewModelScope.launch {
            pokemonGetDetailUseCase.getPokemonDetail(id).collect{
                when(it){
                    is Resource.Error -> fetchLocal(id)
                    is Resource.Loading,is Resource.Success -> _pokemonDetailListLD.postValue(it)
                    is Resource.OnSearch -> {

                    }

                }
            }
        }
    }
    private fun fetchLocal(id:Int){
        viewModelScope.launch {
            localUseCase.getPokemonDetail(id).collect{
                _pokemonDetailListLD.postValue(it)
            }
        }
    }
}