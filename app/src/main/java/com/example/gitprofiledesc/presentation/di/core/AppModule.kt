package com.example.gitprofiledesc.presentation.di.core

import android.content.Context
import com.example.gitprofiledesc.presentation.di.profile.ProfileSubComponent
import dagger.Module
import dagger.Provides

@Module(subcomponents = [ProfileSubComponent::class])
class AppModule(private var context: Context) {

    @Provides
    fun provideApplicationContext(): Context {
       return context.applicationContext
    }
}