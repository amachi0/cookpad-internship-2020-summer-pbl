package jp.amachi0.cookpad_internship_2020_summer_pbl.model

data class Menu(
    val mainDish: Recipe,
    val sideDish: Recipe
) {
    val menuTitle: String =
        buildString {
            append(mainDish.title)
                .append(" / ")
                .append(sideDish.title)
        }

    fun calculateNutrients(): Nutrients {
        return Nutrients(
            calorie = mainDish.calorie + sideDish.calorie,
            protein = mainDish.protain + sideDish.protain,
            lipid = mainDish.lipid + sideDish.lipid
        )
    }

    companion object {
        fun recipeListsToMenus(mainRecipes: List<Recipe>, sideRecipes: List<Recipe>): List<Menu> {
            return mainRecipes.mapIndexed { index, recipe ->
                Menu(
                    mainDish = recipe,
                    sideDish = sideRecipes[index]
                )
            }
        }
    }
}
