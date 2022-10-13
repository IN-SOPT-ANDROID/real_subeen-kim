package org.sopt.sample.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sopt.sample.R
import org.sopt.sample.data.GithubData
import org.sopt.sample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = requireNotNull(_binding) { "바인딩 초기화 에러가 발생했습니다." }
    //private lateinit var title:GithubData.Title
    private lateinit var followerAdapter: FollowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        initAdapter()
        addRepoList()
    }

    private fun initAdapter() {
        followerAdapter = FollowerAdapter(
            GithubData.Title("subeenie")
        )
        binding.rvFollowers.adapter = followerAdapter
    }

    private fun addRepoList() {
        followerAdapter.submitList(
            listOf(
                GithubData.FollowerInfo(
                    1,
                    "김수빈",
                    "수빈",
                    "https://i.pinimg.com/564x/a4/e7/d0/a4e7d05b8b18d1d5426eaee99a8b347c.jpg"
                ),
                GithubData.FollowerInfo(
                    2,
                    "권용민",
                    "용민",
                    "https://i.pinimg.com/564x/93/6b/d3/936bd3a2c7c6f240a09d9f0c703e1e45.jpg"
                ),
                GithubData.FollowerInfo(
                    3,
                    "이준원",
                    "준원",
                    "https://i.pinimg.com/564x/81/f2/1a/81f21ac89afbd03a346a510ccaa99271.jpg"
                ),
                GithubData.FollowerInfo(
                    4,
                    "최윤정",
                    "윤정",
                    "https://i.pinimg.com/564x/78/1e/1f/781e1fbaf6059e930cdfbf9394033bf2.jpg"
                ),
                GithubData.FollowerInfo(
                    5,
                    "최유리",
                    "유리",
                    "https://i.pinimg.com/564x/94/b3/5b/94b35b96c862770dcf9b46b1297e0973.jpg"
                ),
                GithubData.FollowerInfo(
                    6,
                    "채승운",
                    "승운",
                    "https://i.pinimg.com/564x/09/6b/5d/096b5dfab0a254bfec70821cf9e17dd1.jpg"
                ),
                GithubData.FollowerInfo(
                    7,
                    "장유진",
                    "유진",
                    "https://i.pinimg.com/564x/6f/f9/2d/6ff92d33396ba0eb31f47e5f47ae4ed9.jpg"
                ),
                GithubData.FollowerInfo(
                    8,
                    "서동주",
                    "동주",
                    "https://i.pinimg.com/564x/7b/96/dd/7b96ddcd194eaa29152d093075e0490e.jpg"
                )

            )
        )
    }
}
