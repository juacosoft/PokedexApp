package com.juacodev.pokedexapp.ui.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.juacodev.pokedexapp.data.models.PokemonModelR
import com.juacodev.pokedexapp.data.models.PokemonPresenter
import com.juacodev.pokedexapp.databinding.ItemoPokemonBinding
import com.juacodev.pokedexapp.util.IMAGE_URL
import com.juacodev.pokedexapp.util.safeClickListener

class PokemonsAdapter (
    val adapterOnClick : (PokemonPresenter, Int) -> Unit
        ) :RecyclerView.Adapter<PokemonsAdapter.BindableViewHolder>() {

    private var movieModelList= mutableListOf<PokemonPresenter>()

    fun setList(list:List<PokemonPresenter>){
        movieModelList.clear()
        movieModelList.addAll(list)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindableViewHolder {
        val binding = ItemoPokemonBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return BindableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindableViewHolder, position: Int) {
        val item:PokemonPresenter=movieModelList[position]
        holder.itemView.safeClickListener {
            adapterOnClick(item,position)
        }
        holder.bind(item,position)
    }

    override fun getItemCount():Int = movieModelList.size

    inner class BindableViewHolder(
        private val binding: ItemoPokemonBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(pokemon: PokemonPresenter, position:Int) {
            binding.apply {
                tvItemName.text = pokemon.name
                Glide.with(itemView)
                    .load(pokemon.image)
                    .into(ivImagePokemon)
            }
        }

    }


}