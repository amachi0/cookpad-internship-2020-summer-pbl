package jp.amachi0.cookpad_internship_2020_summer_pbl.recipes

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import jp.amachi0.cookpad_internship_2020_summer_pbl.data.repository.RecipesRepository
import jp.amachi0.cookpad_internship_2020_summer_pbl.libs.factory

@Module
interface RecipesFragmentModule {
    @ContributesAndroidInjector(
        modules = [
            Providers::class
        ]
    )
    fun contributeRecipesFragment(): RecipesFragment

    @Module
    object Providers {
        @Provides
        fun provideRecipesViewModel(
            recipesFragment: RecipesFragment,
            recipesRepository: RecipesRepository
        ): RecipesViewModel {
            return ViewModelProvider(recipesFragment,
                factory {
                    RecipesViewModel(
                        recipesRepository
                    )
                }).get()
        }
    }
}