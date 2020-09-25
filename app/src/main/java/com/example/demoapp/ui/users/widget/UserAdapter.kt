package com.example.demoapp.ui.users.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.databinding.ItemProgressBinding
import com.example.demoapp.databinding.ListItemUserPortLandBinding
import com.example.demoapp.routing.AppFragmentNavigator
import com.example.domain.model.User
import kotlinx.android.synthetic.main.item_progress.view.*



/**
 * AdapterUsers
 * Aymen Bouali
 * Coyote
 * @date 24/09/2020
 */
class UserAdapter(val appFragmentNavigator: AppFragmentNavigator): ListAdapter<User, RecyclerView.ViewHolder>(
    DiffCallback()
) {

    // =============================================================================================
    // PARAMATERS
    // =============================================================================================

    private val LOADING: Int = 0;
    private val ITEM: Int = 1;
    private var isLoadingAdded = false
    var mUsers :ArrayList<User> = arrayListOf()


    // =============================================================================================
    // LIFECYCLE
    // =============================================================================================

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            ITEM -> {
                val userViewHolder: UserViewHolder = holder as UserViewHolder
                val user = mUsers.get(position)
                userViewHolder.apply {
                    bind(createOnClickListener(user), user)
                    itemView.tag = user
                }
            }
            LOADING -> {
                val loadingViewHolder: LoadingViewHolder = holder as LoadingViewHolder
                loadingViewHolder.apply {
                    bind()
                    itemView.progressbar.visibility
                }

            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        when (viewType) {
            ITEM -> {

                return UserViewHolder(
                    ListItemUserPortLandBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            }
            LOADING -> {
                return LoadingViewHolder(
                    ItemProgressBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )

            }
            else -> return LoadingViewHolder(
                ItemProgressBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return if (mUsers.size == 0) 0 else mUsers.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == mUsers.size - 1 && isLoadingAdded) LOADING else ITEM
    }


    // =============================================================================================
    // HOLDERS
    // =============================================================================================

    class UserViewHolder(private val binding: ListItemUserPortLandBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: User) {
            binding.apply {
                clickListener = listener
                user = item
                executePendingBindings()
            }
        }
    }

    class LoadingViewHolder(private val binding: ItemProgressBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind() {
            binding.apply {
                executePendingBindings()
            }
        }
    }

    // =============================================================================================
    // PRIVATE
    // =============================================================================================
    private fun createOnClickListener(user: User): View.OnClickListener {
        return View.OnClickListener {
            appFragmentNavigator.showUserDetails(user)
        }
    }

    fun addLoadingFooter() {
        isLoadingAdded = true
    }

    fun removeLoadingFooter() {
        isLoadingAdded = false
        var position: Int = mUsers.size - 1
        val result = getItem(position)
        if (result != null) {
            mUsers.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    fun add(user: User) {
        mUsers.add(user)
        notifyItemInserted(mUsers.size - 1)
    }

    fun addAll(userss: List<User>) {
        for (result in userss) {
            add(result)
        }
    }


}

private class DiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}
