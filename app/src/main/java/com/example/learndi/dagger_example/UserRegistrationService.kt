package com.example.learndi.dagger_example

import javax.inject.Inject
import javax.inject.Named

// constructor injection
class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    @MessageQualifier private val notificationService: NotificationService
) {
    fun registerUser(name: String, email: String) {
        userRepository.saveUser(name, email)
        notificationService.send(email, "no-replybunty@gmail.com", "test body")
    }
}