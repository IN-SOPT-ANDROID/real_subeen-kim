package org.sopt.sample.data.response

import kotlinx.serialization.Serializable
import org.sopt.sample.domain.models.User

@Serializable
data class ResponseSignIn(
    val status: Int,
    val message: String,
    val result: User
)