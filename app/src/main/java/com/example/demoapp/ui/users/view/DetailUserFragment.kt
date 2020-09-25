package com.example.demoapp.ui.users.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demoapp.R
import com.example.demoapp.databinding.FragmentDetailUserBinding
import com.example.demoapp.databinding.FragmentUserListBinding
import com.example.demoapp.ui.base.BaseFragment
import com.example.domain.model.User



/**
 * DetailUserFragment
 * Aymen Bouali
 * Coyote
 * @date 25/09/2020
 */

private const val ARG_PARAM1 = "user"
class DetailUserFragment : BaseFragment() {
    //  parameters
    private var user: User? = null

    // =============================================================================================
    //  LifeCycle
    // =============================================================================================

    override fun viewReady() { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            user = it.getSerializable(ARG_PARAM1) as User?
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var binding = FragmentDetailUserBinding.inflate(inflater, container, false)

        binding.user = user

        return binding.root
    }

    // =============================================================================================
    //  Fragment Instance
    // =============================================================================================

    companion object {

        @JvmStatic
        fun newInstance(user:User) =
            DetailUserFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, user)

                }
            }
    }
}