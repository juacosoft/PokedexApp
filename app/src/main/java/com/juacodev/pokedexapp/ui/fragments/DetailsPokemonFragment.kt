package com.juacodev.pokedexapp.ui.fragments

import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.juacodev.pokedexapp.data.models.PokemonDetailR
import com.juacodev.pokedexapp.data.models.PokemonPresenter
import com.juacodev.pokedexapp.databinding.FragmentDetailsPokemonBinding
import com.juacodev.pokedexapp.ui.base.BaseFragment
import com.juacodev.pokedexapp.ui.viewmodels.DetailsPokemonViewModel
import com.juacodev.pokedexapp.util.Resource
import com.juacodev.pokedexapp.util.UpperCapitalize
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class DetailsPokemonFragment:BaseFragment<FragmentDetailsPokemonBinding>(FragmentDetailsPokemonBinding::inflate) {
    private val detailsViewModel: DetailsPokemonViewModel by viewModels()
    private val args by navArgs<DetailsPokemonFragmentArgs>()
    var pokemon:PokemonPresenter? = null
    override fun onViews() {
        pokemon = args.itemPokemon
        detailsViewModel.syncList(pokemon?.id?:0)
        binding.apply {
            pokemon.let {
                tvDetailPokemonName.text = it?.name?.UpperCapitalize()
                Glide.with(requireContext()).load(it?.image).into(ivDetailPokemonImage)
            }
        }
    }
    override fun onViewModels() {
        detailsViewModel.pokemonDetailListLD.observe(viewLifecycleOwner) {
            when(it){
                is Resource.Error -> {
                    Log.d("Error",it.error.toString())
                }
                is Resource.Loading -> {
                    binding.pbDetailsProgress.visibility = View.VISIBLE
                }
                is Resource.OnSearch -> {
                    //TODO NO NECESARIO
                    Log.d("TAG-444", "OnSearch: ${it.data}")
                }
                is Resource.Success -> {
                    binding.pbDetailsProgress.visibility= View.GONE
                    setData(it.data)
                }
            }
        }
    }

    private fun setData(data: PokemonDetailR?) {
        data.let {
            binding.apply {
                tvDetailHeight.text = it?.height.toString()
                tvDetailWeight.text = it?.weight.toString()
                tvDetailBaseExperience.text = it?.baseExperience.toString()
            }
        }
    }
}
