package com.example.demoapp.ui.users.mv

import com.example.demoapp.ui.base.BaseViewModel
import com.example.demoapp.ui.base.Success
import com.example.demoapp.ui.base.Error
import com.example.demoapp.ui.users.view.UsersViewEffects
import com.example.domain.model.InPut
import com.example.domain.model.User
import com.example.domain.model.onFailure
import com.example.domain.model.onSuccess
import com.example.domain.use_case.GetListUser


/**
 * UsersViewModel
 * Aymen Bouali
 * Coyote
 * @date 22/09/2020
 */
class UsersViewModel(private val getUsers : GetListUser) : BaseViewModel<List<User>, UsersViewEffects>() {
    fun getUsersList(inPut: InPut) = executeUseCase {
        getUsers(inPut)
            .onSuccess { _viewState.value = Success(it) }
            .onFailure { _viewState.value = Error(it.throwable) }
    }
}