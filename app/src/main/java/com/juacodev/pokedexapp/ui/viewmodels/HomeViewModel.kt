package com.juacodev.pokedexapp.ui.viewmodels

import androidx.lifecycle.*
import com.juacodev.pokedexapp.data.models.PokemonPresenter
import com.juacodev.pokedexapp.domain.PokedexRemoteListUseCase
import com.juacodev.pokedexapp.domain.PokemonListLocalUseCase
import com.juacodev.pokedexapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    var useCase: PokedexRemoteListUseCase,
    var localUseCas: PokemonListLocalUseCase
):ViewModel(){

    private val _query = MutableLiveData<String>()
    val query: LiveData<String> get() = _query
    private var limit:Int = 150
    private var offset:Int = 0
    private var _pokemonListLiveData:MutableLiveData<Resource<List<PokemonPresenter>>> = MutableLiveData()
    private var _pokemonListLDFilter:MutableLiveData<Resource<List<PokemonPresenter>>> = MutableLiveData()
    val pokemonList get() = _pokemonListLiveData
    fun syncList(){
        viewModelScope.launch(Dispatchers.IO) {
            useCase.getPokemonListRemote(limit,offset).collect {
                when(it){
                    is Resource.Error -> {
                        fetchLocal()
                    }
                    is Resource.Loading,is Resource.Success -> {
                        _pokemonListLiveData.postValue(it)
                    }
                    is Resource.OnSearch -> {

                    }
                }

            }
        }
    }
    private fun fetchLocal(){
        viewModelScope.launch(Dispatchers.IO) {
            localUseCas.getPokemonListLocal().collect {
                _pokemonListLiveData.postValue(it)
            }
        }
    }
    fun filterByQuery(query:String){
        val currentQuery=_query.value
        if(currentQuery!=query)
            _query.value=query
        val originalList = pokemonList.value?.data?: emptyList()
        _pokemonListLiveData.value =
            if(query.isNotEmpty())
                originalList.filter {
                    it.name.contains(query,true)
                }.let {
                    Resource.OnSearch(it)
                }
            else
                Resource.OnSearch(originalList)

    }


}