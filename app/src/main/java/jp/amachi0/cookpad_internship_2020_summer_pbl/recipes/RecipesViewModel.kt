package jp.amachi0.cookpad_internship_2020_summer_pbl.recipes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import jp.amachi0.cookpad_internship_2020_summer_pbl.data.repository.RecipesRepository
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.Menu
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.NutrientsAndFeeling
import javax.inject.Inject

class RecipesViewModel @Inject constructor(
    private val recipesRepository: RecipesRepository
) : ViewModel() {
    private val _recipes = MutableLiveData<List<Menu>>()
    val recipes = _recipes

    fun updateRecipes(nutrientsAndFeeling: NutrientsAndFeeling) {
        val menus = recipesRepository.getRecipeSet(nutrientsAndFeeling)
        _recipes.postValue(menus)
    }

    override fun onCleared() {
        super.onCleared()
        recipesRepository.refresh()
    }
}