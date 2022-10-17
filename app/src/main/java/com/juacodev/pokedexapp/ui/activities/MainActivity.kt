package com.juacodev.pokedexapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.juacodev.pokedexapp.R
import com.juacodev.pokedexapp.databinding.ActivityMainBinding
import com.juacodev.pokedexapp.ui.fragments.HomeFragmentDirections
import com.juacodev.pokedexapp.ui.viewmodels.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val activityViewModel: MainActivityViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView)as NavHostFragment

        navController=navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id){
                R.id.homeFragment->{
                    binding.topAppBar.navigationIcon=null
                }
                R.id.pokemonListFragment->{
                    binding.topAppBar.navigationIcon=resources.getDrawable(R.drawable.ic_arrow_back)
                   Log.d("TAG-55", "destination: ${destination.label}")
                }

            }
        }
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }

        setupObservers()

    }
    private fun setupObservers() {

    }

    override fun onBackPressed() {
        if(!navController.navigateUp()) {
            super.onBackPressed()
        }
    }
}