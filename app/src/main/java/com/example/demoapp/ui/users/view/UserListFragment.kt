package com.example.demoapp.ui.users.view

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapp.R
import com.example.demoapp.common.snackbar
import com.example.demoapp.common.subscribe
import com.example.demoapp.databinding.FragmentUserListBinding
import com.example.demoapp.ui.base.*
import com.example.demoapp.ui.users.mv.UsersViewModel
import com.example.demoapp.ui.users.widget.PaginationScrollListener
import com.example.demoapp.ui.users.widget.UserAdapter
import com.example.domain.model.InPut
import com.example.domain.model.User
import kotlinx.android.synthetic.main.fragment_user_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * DetailUserFragment
 * Aymen Bouali
 * Coyote
 * @date 23/09/2020
 */
class UserListFragment : BaseFragment() {
    //  parameters

    private val mViewModel: UsersViewModel by viewModel()
    lateinit var mAdapter : UserAdapter
    private val PAGE_START = 1
    private var isLoading = false
    private var isLastPage = false
    private val TOTAL_PAGES = 20
    private val SEED = "aa"

    private var mCurrentPage = PAGE_START
    lateinit var mBinding : FragmentUserListBinding
    lateinit var mLinearLayoutManager:LinearLayoutManager



    // =============================================================================================
    //  LifeCycle
    // =============================================================================================
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mBinding = FragmentUserListBinding.inflate(inflater, container, false)

        return mBinding.root
    }


    override fun viewReady() {

        subscribeToData()
    }

    override fun onResume() {
        super.onResume()
        showLoading(mBinding.userLoadingProgress)
        showMyRecycleView()
        mViewModel.getUsersList(InPut(PAGE_START, TOTAL_PAGES, SEED))
    }


    // =============================================================================================
    // VIEWMODEL SUBSCRIBE
    // =============================================================================================
    private fun subscribeToData() {
        mViewModel.viewState.subscribe(this, ::handleViewState)
    }

    // =============================================================================================
    //  RecycleView Display Pagination
    // =============================================================================================

    private fun showMyRecycleView(){
        mAdapter = UserAdapter(appFragmentNavigator)
        mLinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mBinding.recyclerView.layoutManager = mLinearLayoutManager
        mBinding.recyclerView.adapter = mAdapter
        mBinding.recyclerView.addOnScrollListener(object : PaginationScrollListener(mLinearLayoutManager) {

            override fun loadMoreItems() {
                isLoading = true
                mCurrentPage += 1
                loadNextPage()
            }

            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading;
            }

        })
    }

    // =============================================================================================
    // PRIVATE
    // =============================================================================================

    private fun handleViewState(viewState: ViewState<List<User>>) {
        when (viewState) {
            is Success -> showUserData(viewState.data)
            is Error -> handleError(viewState.error.localizedMessage)
            is NoInternetState -> showNoInternetError()
        }
    }
    private fun handleError(error: String) {
        hideLoading(mBinding.userLoadingProgress)
       showError(error, userFragmentContainer)
    }

    private fun showNoInternetError() {
        hideLoading(mBinding.userLoadingProgress)
        snackbar(getString(R.string.no_internet_error_message), userFragmentContainer)
    }

    private fun showUserData(users: List<User>) {
            hideLoading(mBinding.userLoadingProgress)
            users?.let {
                isLoading = false
                mAdapter.addAll(it)
                if (mCurrentPage <= TOTAL_PAGES) mAdapter.addLoadingFooter()
                else isLastPage = true
        }

    }
    private fun loadNextPage() {
        mViewModel.getUsersList(InPut(mCurrentPage, TOTAL_PAGES, SEED))
    }

    // =============================================================================================
    //  Fragment Instance
    // =============================================================================================


    companion object {
        fun newInstance() = UserListFragment()
    }


}