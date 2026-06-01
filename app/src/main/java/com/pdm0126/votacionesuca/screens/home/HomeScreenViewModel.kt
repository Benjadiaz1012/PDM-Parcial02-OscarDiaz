package com.pdm0126.votacionesuca.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pdm0126.votacionesuca.data.api.repositories.VoteRepository.VoteApiRepository
import com.pdm0126.votacionesuca.data.api.repositories.VoteRepository.VoteRepository
import com.pdm0126.votacionesuca.model.Vote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val VoteRepository: VoteRepository = VoteApiRepository()
    private val _votes = MutableStateFlow<List<Vote>>(emptyList())
    val votes = _votes.asStateFlow()

    init {
        loadVotes()
    }

    fun loadVotes() {
        viewModelScope.launch {
            VoteRepository.getVotes().onSuccess { votes -> _votes.value = votes }
        }
    }
}