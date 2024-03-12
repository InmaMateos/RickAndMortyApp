package com.example.rickandmortyapp.ui.list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.databinding.ItemCharacterBinding
import com.example.rickandmortyapp.domain.model.CharacterModel

class CharacterListViewHolder (view :View): RecyclerView.ViewHolder(view) {
     private val binding = ItemCharacterBinding.bind(view)
    fun bind(characterList: CharacterModel) {
        binding.tvCharacter.text = characterList.name
        Glide.with(binding.ivCharacter.context)
            .load(characterList.image)
            .into(binding.ivCharacter)
    }
}