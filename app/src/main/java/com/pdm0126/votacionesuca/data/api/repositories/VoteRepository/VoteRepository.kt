package com.pdm0126.votacionesuca.data.api.repositories.VoteRepository

import com.pdm0126.votacionesuca.model.Vote

interface VoteRepository {
    suspend fun getVotes(): Result<List<Vote>>
}