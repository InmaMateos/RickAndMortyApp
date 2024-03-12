package com.example.rickandmortyapp.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.domain.model.CharacterModel

class CharacterListAdapter( private var characterList: List<CharacterModel>): RecyclerView.Adapter<CharacterListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        return CharacterListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        )
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.bind(characterList[position])
    }
}