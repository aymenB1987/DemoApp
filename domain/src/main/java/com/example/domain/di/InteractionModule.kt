package com.example.domain.di

import com.example.domain.repository.GetListUserImpl
import com.example.domain.use_case.GetListUser
import org.koin.dsl.module
/**
 * Uses case Injection Dependences
 * Aymen Bouali
 * Coyote
 * @date 18/09/2020
 */
val interactionModule = module {
    factory<GetListUser> { GetListUserImpl(get()) }
}