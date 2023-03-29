package com.example.learndi.dagger_example

import android.util.Log
import javax.inject.Inject


interface UserRepository {
    fun saveUser(name: String, email: String)
}

@ActivityScope
class SqlRepo @Inject constructor(private val analyticsService: AnalyticsService) :
    UserRepository {
    override fun saveUser(name: String, email: String) {
        Log.d("buntyTag", "User saved in db $name , $email")
        analyticsService.trackEvent("save user in db", "test event")
    }
}

class FirebaseRepo(private val analyticsService: AnalyticsService) :
    UserRepository {
    override fun saveUser(name: String, email: String) {
        Log.d("buntyTag", "User saved in firebase $name , $email")
        analyticsService.trackEvent("save user in firebase", "test event")
    }
}