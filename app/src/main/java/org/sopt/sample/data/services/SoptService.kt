package org.sopt.sample.data.services

import org.sopt.sample.data.request.RequestSignIn
import org.sopt.sample.data.request.RequestSignUp
import org.sopt.sample.data.response.ResponseSignIn
import org.sopt.sample.data.response.ResponseSignUp
import retrofit2.http.Body
import retrofit2.http.POST

interface SoptService {
    @POST("/api/user/signin")
    suspend fun postSignIn(@Body body: RequestSignIn): ResponseSignIn

    @POST("/api/user/signup")
    suspend fun postSignUp(@Body body: RequestSignUp): ResponseSignUp
}