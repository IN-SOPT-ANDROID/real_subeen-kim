package org.sopt.sample.data

data class GithubData(
    val followers: List<FollowerInfo>,
    val title: Title
) {
    data class FollowerInfo(
        val id: Int,
        val repo: String? = "No Repository",
        val nickname: String,
        val profileImage: String,
    )

    data class Title(
        val title: String = "Subeenie"
    )
}