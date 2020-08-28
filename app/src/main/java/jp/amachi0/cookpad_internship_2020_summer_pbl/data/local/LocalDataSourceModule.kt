package jp.amachi0.cookpad_internship_2020_summer_pbl.data.local

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [LocalDataSourceModule.Providers::class])
internal abstract class LocalDataSourceModule {
    @Binds
    abstract fun recipesLocalDataSource(impl: AssetsLocalDataSource): LocalDataSource

    @Module
    internal object Providers {
        @Singleton
        @Provides
        fun provideRecipeDataSource(
            application: Application
        ): AssetsLocalDataSource {
            return AssetsLocalDataSource(application)
        }
    }
}