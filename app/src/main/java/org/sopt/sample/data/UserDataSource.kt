package org.sopt.sample.data

import org.sopt.sample.data.request.RequestSignIn
import org.sopt.sample.data.request.RequestSignUp
import org.sopt.sample.data.response.ResponseSignIn
import org.sopt.sample.data.response.ResponseSignUp
import org.sopt.sample.data.services.SoptService
import javax.inject.Inject

class UserDataSource @Inject constructor(
    private val soptService: SoptService
) {
    suspend fun postSignIn(requestSignIn: RequestSignIn): ResponseSignIn =
        soptService.postSignIn(requestSignIn)

    suspend fun postSignUp(requestSignUp: RequestSignUp): ResponseSignUp =
        soptService.postSignUp(requestSignUp)
}