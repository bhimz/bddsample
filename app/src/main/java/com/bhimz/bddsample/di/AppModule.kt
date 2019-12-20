package com.bhimz.bddsample.di

import com.bhimz.bddsample.repository.UserRepository
import com.bhimz.bddsample.repository.UserRepositoryImpl
import org.koin.dsl.module


val appModule = module {
    factory<UserRepository> { UserRepositoryImpl() }
}
