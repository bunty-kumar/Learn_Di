package com.example.learndi

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.learndi.dagger_example.EmailService
import com.example.learndi.dagger_example.UserApplication
import com.example.learndi.dagger_example.UserRegistrationService
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var value = 0
    private lateinit var btnTap: Button
    private lateinit var tvValue: TextView

    // field injection------:
    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @Inject
    lateinit var emailService: EmailService

    @Inject
    lateinit var emailService1: EmailService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTap = findViewById(R.id.tapBtn)
        tvValue = findViewById(R.id.tvValue)
        "value is:- $value".also { tvValue.text = it }
        btnTap.setOnClickListener {
            increaseValue()
            Log.e("buntyTag", "button clicked")
        }

        val appComponents = (application as UserApplication).appComponents
        val userRegistrationComponents =
            appComponents.getUserRegistrationComponentsBuilder().retryCount(3).build()
        userRegistrationComponents.inject(this)
        userRegistrationService.registerUser("bunty", "bk2271999@gmail.cpm")

    }

    private fun increaseValue() {
        value += 1
        "value is:- $value".also { tvValue.text = it }
    }
}