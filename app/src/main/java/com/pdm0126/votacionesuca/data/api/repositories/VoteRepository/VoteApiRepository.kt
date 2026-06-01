package com.pdm0126.votacionesuca.data.api.repositories.VoteRepository

import com.pdm0126.votacionesuca.data.api.KtorClient
import com.pdm0126.votacionesuca.data.api.Voting.GetVoteDTO
import com.pdm0126.votacionesuca.data.api.Voting.toModel
import com.pdm0126.votacionesuca.model.Vote
import io.ktor.client.call.body
import io.ktor.client.request.get

class VoteApiRepository : VoteRepository {
    override suspend fun getVotes(): Result<List<Vote>> {
        try {
            val response: List<GetVoteDTO> = KtorClient.client.get("options") {

            }.body()
            return Result.success(response.map { GetVoteDTO -> GetVoteDTO.toModel() })
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

    override suspend fun postVotes(optionId: Int): Result<GetVoteDTO> {
        TODO("Not yet implemented")
    }

}