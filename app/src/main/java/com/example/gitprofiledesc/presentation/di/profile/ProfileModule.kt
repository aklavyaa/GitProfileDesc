package com.example.gitprofiledesc.presentation.di.profile

import com.example.gitprofiledesc.domain.profile.ProfileDetailUseCase
import com.example.gitprofiledesc.domain.profile.ProfileUpdateDetailUseCase
import com.example.gitprofiledesc.presentation.profile.ProfileFactoryVM
import dagger.Module
import dagger.Provides

@Module
class ProfileModule {

    @ProfileScope
    @Provides
    fun provideProfileViewModelFactory(
        profileDetailUseCase: ProfileDetailUseCase,
        updateDetailUseCase: ProfileUpdateDetailUseCase,
    ): ProfileFactoryVM {
        return ProfileFactoryVM(
            profileDetailUseCase,
            updateDetailUseCase,
        )
    }
}