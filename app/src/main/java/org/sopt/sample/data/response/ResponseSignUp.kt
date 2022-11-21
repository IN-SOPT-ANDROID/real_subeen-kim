package org.sopt.sample.data.response

import kotlinx.serialization.Serializable
import org.sopt.sample.domain.models.User

@Serializable
data class ResponseSignUp(
    val status: Int,
    val message: String,
    val newUser: User
)