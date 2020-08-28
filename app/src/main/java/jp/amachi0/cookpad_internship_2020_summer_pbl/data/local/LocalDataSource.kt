package jp.amachi0.cookpad_internship_2020_summer_pbl.data.local

import jp.amachi0.cookpad_internship_2020_summer_pbl.model.Feeling

interface LocalDataSource {
    fun fetchMainDishes(feeling: Feeling): RecipesJsonEntity
    fun fetchSideDishes(): RecipesJsonEntity
}