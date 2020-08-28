package jp.amachi0.cookpad_internship_2020_summer_pbl.data.repository.mapper

import jp.amachi0.cookpad_internship_2020_summer_pbl.data.local.RecipeJsonEntity
import jp.amachi0.cookpad_internship_2020_summer_pbl.data.local.RecipesJsonEntity
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.Recipe

fun RecipesJsonEntity.toListRecipes(): List<Recipe> {
    return recipes.map {
        it.toRecipe()
    }
}

fun RecipeJsonEntity.toRecipe() =
    Recipe(
        id = id.toInt(),
        title = title,
        image = image,
        calorie = calorie,
        protain = protain,
        lipid = lipid
    )