package com.example.learndi.dagger_example

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton


interface NotificationService {
    fun send(to: String, from: String, body: String?)
}

@ActivityScope
class EmailService @Inject constructor() : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d("buntyTag", "email notification sent")
    }
}

class MessageService(private val retryCount: Int) : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d("buntyTag", "message notification sent - retry count $retryCount")
    }
}