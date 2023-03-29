package com.example.learndi.dagger_example

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponents {
//    fun getUserRegistrationComponentsFactory(): UserRegistrationComponents.Factory
    fun getUserRegistrationComponentsBuilder(): UserRegistrationComponents.Builder
//    fun getUserRegistrationComponents(): UserRegistrationComponents
}