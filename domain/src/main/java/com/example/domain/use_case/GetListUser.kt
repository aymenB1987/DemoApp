package com.example.domain.use_case

import android.renderscript.ScriptGroup
import com.example.domain.base.BaseUseCase
import com.example.domain.model.InPut
import com.example.domain.model.Result
import com.example.domain.model.User

/**
 * ListUserUseCase
 * Aymen Bouali
 * Coyote
 * @date 18/09/2020
 */
interface GetListUser : BaseUseCase<InPut, List<User>>{
    override suspend operator fun invoke(inPut: InPut): Result<List<User>>
}