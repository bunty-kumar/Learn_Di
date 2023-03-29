package com.example.learndi.dagger_example

import dagger.Binds
import dagger.Module

@Module
abstract class UserRepositoryModule {

    /*@Provides
    fun getFirebaseUser(): UserRepository {
        return FirebaseRepo()
    }*/

    /*@Provides
    fun getSqlRepo(sqlRepo: SqlRepo): UserRepository {
        return sqlRepo
    }*/

    @Binds
    @ActivityScope
    abstract fun getSqlRepo(sqlRepo: SqlRepo): UserRepository
}