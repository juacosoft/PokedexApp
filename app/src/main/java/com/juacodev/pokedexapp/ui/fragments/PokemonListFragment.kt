package com.juacodev.pokedexapp.ui.fragments

import android.util.Log
import android.view.View
import android.widget.SearchView
import androidx.activity.addCallback
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.juacodev.pokedexapp.data.models.PokemonModelR
import com.juacodev.pokedexapp.data.models.PokemonPresenter
import com.juacodev.pokedexapp.databinding.FragmentPokemonsListBinding
import com.juacodev.pokedexapp.ui.base.BaseFragment
import com.juacodev.pokedexapp.ui.components.PokemonsAdapter
import com.juacodev.pokedexapp.ui.viewmodels.HomeViewModel
import com.juacodev.pokedexapp.util.Resource
import com.juacodev.pokedexapp.util.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonListFragment :BaseFragment<FragmentPokemonsListBinding>(FragmentPokemonsListBinding::inflate) {
    private val homeViewModel: HomeViewModel by viewModels()
    lateinit var adapter: PokemonsAdapter
    override fun onViews() {
        adapter = PokemonsAdapter{item,pos->
            adapterDoClick(item,pos)
        }
        homeViewModel.syncList()
        binding.apply {
            rvHomepokemonlist.adapter = adapter
            svHome.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    query.let {
                        homeViewModel.filterByQuery(it!!)
                    }
                    return false
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    if(newText.isNullOrEmpty()){
                        homeViewModel.syncList()
                        svHome.clearFocus()
                    }
                    return true
                }
            })
        }



    }

    override fun onViewModels() {

        homeViewModel.pokemonList.observe(viewLifecycleOwner) {
            when(it){
                is Resource.Error -> {
                    binding.contentLayoutError.visibility = View.VISIBLE
                    binding.contentLayoutLoading.visibility = View.GONE
                    binding.rvHomepokemonlist.visibility = View.GONE
                }
                is Resource.Loading -> {
                    binding.contentLayoutLoading.visibility = View.VISIBLE
                    binding.rvHomepokemonlist.visibility = View.GONE
                }
                is Resource.Success -> {
                    binding.contentLayoutLoading.visibility = View.GONE
                    binding.rvHomepokemonlist.visibility = View.VISIBLE
                    adapter.setList(it.data?: emptyList())
                }
                is Resource.OnSearch -> {
                    adapter.setList(it.data?: emptyList())
                }
            }

        }

    }
    private fun adapterDoClick(itemPokemon:PokemonPresenter, pos:Int){
        Log.d("TAG-55", "adapterDoClick: ${itemPokemon.name} Id: $pos")
        val action = PokemonListFragmentDirections.actionPokemonListFragmentToDetailsPokemonFragment(itemPokemon)
        findNavController().navigate(action)
    }
}