package org.sopt.sample.domain.repositories

import org.sopt.sample.data.response.ResponseSignIn
import org.sopt.sample.data.response.ResponseSignUp

interface UserRepository {
    suspend fun postSignIn(email: String, password: String): Result<ResponseSignIn>
    suspend fun postSignUp(email: String, password: String, name: String): Result<ResponseSignUp>
}