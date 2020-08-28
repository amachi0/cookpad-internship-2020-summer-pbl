package jp.amachi0.cookpad_internship_2020_summer_pbl.recipes

import dagger.Module


@Module(
    includes = [
        RecipesFragmentModule::class
    ]
)
interface RecipesModule