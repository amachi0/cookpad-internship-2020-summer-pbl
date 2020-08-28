package jp.amachi0.cookpad_internship_2020_summer_pbl.data.local

import android.content.Context
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.Feeling
import kotlinx.serialization.json.Json

class AssetsLocalDataSource(
    private val context: Context
) : LocalDataSource {
    companion object {
        private const val SIDE_DISHES_FILE_NAME = "side"
    }

    override fun fetchMainDishes(feeling: Feeling): RecipesJsonEntity {
        return loadJson(feeling.value)
    }

    override fun fetchSideDishes(): RecipesJsonEntity {
        return loadJson(SIDE_DISHES_FILE_NAME)
    }

    private fun loadJson(filename: String): RecipesJsonEntity {
        val assetManager = context.resources.assets
        val inputStream = assetManager.open("${filename}.json")
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        return Json.decodeFromString(RecipesJsonEntity.serializer(), jsonString)
    }
}