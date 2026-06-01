package com.pdm0126.votacionesuca.data.api.Voting

import com.pdm0126.votacionesuca.model.Vote
import kotlinx.serialization.Serializable
import kotlin.Int

@Serializable
data class GetVoteDTO(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val votes: Int
)

fun GetVoteDTO.toModel(): Vote {
    return Vote(
        id = id,
        name = name,
        imageUrl = imageUrl,
        votes = votes
    )
}