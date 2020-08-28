package jp.amachi0.cookpad_internship_2020_summer_pbl.data.repository

import android.util.Log
import jp.amachi0.cookpad_internship_2020_summer_pbl.data.local.LocalDataSource
import jp.amachi0.cookpad_internship_2020_summer_pbl.data.repository.mapper.toListRecipes
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.Menu
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.Nutrients
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.NutrientsAndFeeling
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.Recipe
import javax.inject.Inject

class RecipesRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource
) : RecipesRepository {
    companion object {
        private const val RECIPE_SIZE_MAX = 100
    }

    private var mainRecipesCache: List<Recipe> = listOf()
    private var sideRecipesCache: List<Recipe> = listOf()

    private var menusCache: MutableList<Menu> = mutableListOf()

    override fun getRecipeSet(nutrientsAndFeeling: NutrientsAndFeeling): List<Menu> {
        if (!menusCache.isNullOrEmpty()) {
            return menusCache
        }

        if (mainRecipesCache.isNullOrEmpty()) {
            val mainDishes = localDataSource
                .fetchMainDishes(nutrientsAndFeeling.feeling)
                .toListRecipes()
            mainRecipesCache = mainDishes
        }
        if (sideRecipesCache.isNullOrEmpty()) {
            val sideDishes = localDataSource.fetchSideDishes().toListRecipes()
            sideRecipesCache = sideDishes
        }

        val filteredMainRecipes = findRecipesToMatchNutrients(
            nutrientsAndFeeling.nutrients,
            mainRecipesCache
        ).apply {
            if (size > RECIPE_SIZE_MAX) {
                shuffled().subList(0, RECIPE_SIZE_MAX)
            }
        }

        val mainRecipesSize = filteredMainRecipes.size
        val sideRecipes = sideRecipesCache.shuffled().subList(0, mainRecipesSize)
        Log.d("side_dish", sideRecipes.toString())

        val menus = Menu.recipeListsToMenus(filteredMainRecipes, sideRecipes)
        menusCache.addAll(menus)

        return menus
    }

    override fun refresh() {
        Log.d("refresh!!!", "refresh!!!")
        menusCache.clear()
    }


    private fun findRecipesToMatchNutrients(
        nutrients: Nutrients,
        recipes: List<Recipe>
    ): List<Recipe> {
        Log.d("recipes size", recipes.size.toString())
        val filterd = recipes.filter {
            nutrients.calorie - nutrients.calorieRange <= it.calorie
                    && it.calorie <= nutrients.calorie
                    && nutrients.protein - nutrients.proteinRange <= it.protain
                    && it.protain <= nutrients.protein
                    && nutrients.lipid - nutrients.lipidRange <= it.lipid
                    && it.lipid <= nutrients.lipid
        }
        Log.d("filtered recipes size", filterd.size.toString())
        return filterd
    }

}
