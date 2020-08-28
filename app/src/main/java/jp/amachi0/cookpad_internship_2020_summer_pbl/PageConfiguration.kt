package jp.amachi0.cookpad_internship_2020_summer_pbl

import androidx.annotation.IdRes

enum class PageConfiguration(
    val id: Int,
    val title: Int,
    val isToolbarVisible: Boolean = true
) {
    NUTRIENTS(
        R.id.nutrients,
        R.string.title_nutrients
    ),
    FEELING(
        R.id.feeling,
        R.string.title_feeling
    ),
    RECIPES(
        R.id.recipes,
        R.string.title_recipes,
        false
    ),
    RECIPE_DETAIL(
        R.id.recipe_detail,
        R.string.title_recipe_detail
    ),
    OTHER(
        0,
        R.string.app_name
    );

    operator fun component1() = id
    operator fun component2() = title

    companion object {
        fun getConfiguration(@IdRes id: Int): PageConfiguration {
            return PageConfiguration
                .values()
                .firstOrNull { it.id == id } ?: OTHER
        }
    }
}
