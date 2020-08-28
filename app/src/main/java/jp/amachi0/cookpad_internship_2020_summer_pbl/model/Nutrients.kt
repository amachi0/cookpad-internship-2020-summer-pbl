package jp.amachi0.cookpad_internship_2020_summer_pbl.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Nutrients(
    val calorie: Int,
    val protein: Int,
    val lipid: Int,
    val calorieRange: Int = 100,
    val proteinRange: Int = 10,
    val lipidRange: Int = 10
) : Parcelable