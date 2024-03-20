package com.example.rickandmortyapp.ui.detail.view

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentCharacterDetailBinding
import com.example.rickandmortyapp.ui.detail.CharacterDetailState
import com.example.rickandmortyapp.ui.detail.viewModel.CharacterDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CharacterDetailFragment : Fragment() {

    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding get() = _binding!!

    private val characterDetailViewModel: CharacterDetailViewModel by viewModels()

    private val args: CharacterDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterDetailViewModel.getCharacterDetail(args.characterId)
        initUI()
    }

    private fun initUI() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                characterDetailViewModel.state.collect {
                    when (it) {
                        CharacterDetailState.Loading -> loadingState()
                        is CharacterDetailState.Success -> successState(it)
                        is CharacterDetailState.Error -> errorState()
                    }
                }
            }
        }
    }


    private fun successState(it: CharacterDetailState.Success) {

        val color = when (it.character.status) {
            "Alive" -> R.color.green
            "Dead" -> R.color.red
            else -> R.color.black
        }
        binding.pbar.isVisible = false
        binding.tvCharacterName.text = it.character.name
        binding.rbStatus.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(
                binding.rbStatus.context, color
            )
        )
        binding.tvStatus.text = it.character.status
        binding.tvSpecies.text = it.character.species
        binding.tvType.text = it.character.type
        binding.tvGender.text = it.character.gender

        Glide.with(binding.ivCharacterDetail.context)
        .load(it.character.image)
        .into(binding.ivCharacterDetail)

    }


    private fun loadingState() {
        binding.pbar.isVisible = true
    }
    private fun errorState() {
        binding.pbar.isVisible = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}