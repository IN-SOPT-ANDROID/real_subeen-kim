package org.sopt.sample.presentation.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.sopt.sample.data.GithubData
import org.sopt.sample.databinding.ItemListRepositoryBinding
import org.sopt.sample.databinding.ItemListTitleBinding
import org.sopt.sample.util.loadCircleImage

private const val TITLE_TYPE = 1
private const val FOLLOWER_TYPE = 2

class FollowerAdapter(
    private val title: GithubData.Title
) :
    ListAdapter<GithubData.FollowerInfo, FollowerAdapter.GithubViewHolder>(
        DIFFUTIL()
    ) {
    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TITLE_TYPE
            else -> FOLLOWER_TYPE
        }
    }

    abstract class GithubViewHolder(
        protected val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        abstract fun bind(input: GithubInput)
    }

    class GithubTitleViewHolder(
        binding: ItemListTitleBinding
    ) : GithubViewHolder(binding) {
        override fun bind(input: GithubInput) {
            if (input is GithubInput.Title) {
                (binding as ItemListTitleBinding).tvTitle.text = input.data.title
                Log.e("githubinput","${input.data.title}")
            }
        }
    }

    class GithubRepoViewHolder(
        binding: ItemListRepositoryBinding,
    ) : GithubViewHolder(binding) {
        override fun bind(input: GithubInput) {
            if (input is GithubInput.Follower) {
                with(binding as ItemListRepositoryBinding) {
                    tvRepo.text = input.data.repo
                    tvFollowerName.text = input.data.nickname
                    ivProfile.loadCircleImage(input.data.profileImage)
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubViewHolder {
        return when (viewType) {
            TITLE_TYPE -> {
                val binding = ItemListTitleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                GithubTitleViewHolder(binding)
            }
            else -> {
                val binding = ItemListRepositoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                GithubRepoViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = currentList.size + 1

    override fun onBindViewHolder(holder: GithubViewHolder, position: Int) {
        holder.bind((if (position == 0) title.toInput() else getItem(position - 1).toInput()) as GithubInput)
    }

    private fun GithubData.Title.toInput() = GithubInput.Title(this)
    private fun GithubData.FollowerInfo.toInput() = GithubInput.Follower(this)

    sealed class GithubInput {
        data class Title(val data: GithubData.Title) : GithubInput()
        data class Follower(val data: GithubData.FollowerInfo) : GithubInput()
    }

    private class DIFFUTIL : DiffUtil.ItemCallback<GithubData.FollowerInfo>() {
        override fun areItemsTheSame(
            oldItem: GithubData.FollowerInfo,
            newItem: GithubData.FollowerInfo
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: GithubData.FollowerInfo,
            newItem: GithubData.FollowerInfo
        ) = oldItem == newItem
    }
}

