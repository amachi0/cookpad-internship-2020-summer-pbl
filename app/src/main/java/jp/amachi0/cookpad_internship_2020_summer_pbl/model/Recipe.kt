package jp.amachi0.cookpad_internship_2020_summer_pbl.model

data class Recipe(
    val id: Int,
    val title: String,
    val image: String,
    val calorie: Int,
    val protain: Int,
    val lipid: Int
)
