package com.juacodev.pokedexapp.ui.fragments

import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.juacodev.pokedexapp.databinding.FragmentHomeBinding
import com.juacodev.pokedexapp.ui.base.BaseFragment
import com.juacodev.pokedexapp.ui.viewmodels.HomeViewModel
import com.juacodev.pokedexapp.ui.viewmodels.MainActivityViewModel
import com.juacodev.pokedexapp.util.safeClickListener

class HomeFragment :BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val activityViewModel: MainActivityViewModel by activityViewModels()
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViews() {
        binding.btnPokemon.safeClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToPokemonListFragment()
            findNavController().navigate(action)
        }
    }
    override fun onViewModels() {
    }
}
