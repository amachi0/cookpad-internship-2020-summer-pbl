package jp.amachi0.cookpad_internship_2020_summer_pbl.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module(includes = [])
object AppModule {
    @Provides
    fun provideAppContext(application: Application): Context {
        return application
    }
}
