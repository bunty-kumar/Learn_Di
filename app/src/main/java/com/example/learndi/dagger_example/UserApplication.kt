package com.example.learndi.dagger_example

import android.app.Application

class UserApplication : Application() {
    //    lateinit var userRegistrationComponents: UserRegistrationComponents
    lateinit var appComponents: AppComponents
    override fun onCreate() {
        super.onCreate()
        appComponents = DaggerAppComponents.builder().build()
//        userRegistrationComponents = DaggerUserRegistrationComponents.factory().create(3)
    }
}