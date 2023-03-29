package com.example.learndi.dagger_example

import com.example.learndi.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [UserRepositoryModule::class, NotificationServiceModule::class]
)
interface UserRegistrationComponents {

    fun inject(mainActivity: MainActivity)

    /*@Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance retryCount: Int
        ): UserRegistrationComponents
    }*/

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserRegistrationComponents
        fun retryCount(@BindsInstance retryCount: Int): Builder
    }
}