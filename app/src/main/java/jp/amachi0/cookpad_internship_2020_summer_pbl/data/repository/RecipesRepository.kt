package jp.amachi0.cookpad_internship_2020_summer_pbl.data.repository

import jp.amachi0.cookpad_internship_2020_summer_pbl.model.Menu
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.NutrientsAndFeeling

interface RecipesRepository {
    fun getRecipeSet(nutrientsAndFeeling: NutrientsAndFeeling): List<Menu>
    fun refresh()
}
