package com.pdm0126.votacionesuca.data.api.Voting

import kotlinx.serialization.Serializable

@Serializable
data class PostVoteDTO(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val votes: Int
)
@Serializable
data class PostVote(
    val optionId: Int
)