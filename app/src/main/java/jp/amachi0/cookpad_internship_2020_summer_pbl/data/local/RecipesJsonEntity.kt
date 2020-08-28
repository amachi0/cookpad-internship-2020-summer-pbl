package jp.amachi0.cookpad_internship_2020_summer_pbl.data.local

import kotlinx.serialization.Serializable

@Serializable
data class RecipesJsonEntity(
    val recipes: List<RecipeJsonEntity>
)

@Serializable
data class RecipeJsonEntity(
    val id: String,
    val title: String,
    val image: String,
    val calorie: Int,
    val protain: Int,
    val lipid: Int
)