package org.sopt.sample.data.repositories

import org.sopt.sample.data.UserDataSource
import org.sopt.sample.data.request.RequestSignIn
import org.sopt.sample.data.request.RequestSignUp
import org.sopt.sample.data.response.ResponseSignIn
import org.sopt.sample.data.response.ResponseSignUp
import org.sopt.sample.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSource: UserDataSource
) : UserRepository {

    override suspend fun postSignIn(email: String, password: String): Result<ResponseSignIn> =
        kotlin.runCatching {
            userDataSource.postSignIn(RequestSignIn(email, password))
        }


    override suspend fun postSignUp(email: String, password: String, name: String): Result<ResponseSignUp> =
        kotlin.runCatching { userDataSource.postSignUp(RequestSignUp(email, password, name)) }
}
// rusult 로 반환타입을 해주면 viewmodel에서 똑같은 코드 작성 안해도 됨
// 예를 들어 runcatching.fold 즉, 성공, 실패 관한 코드 똑같이 안써도됨.