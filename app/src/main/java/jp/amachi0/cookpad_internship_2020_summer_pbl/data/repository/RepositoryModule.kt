package jp.amachi0.cookpad_internship_2020_summer_pbl.data.repository

import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryModule.Providers::class])
internal abstract class RepositoryModule {
    @Binds
    abstract fun recipesRepository(impl: RecipesRepositoryImpl): RecipesRepository

    @Module
    internal object Providers
}