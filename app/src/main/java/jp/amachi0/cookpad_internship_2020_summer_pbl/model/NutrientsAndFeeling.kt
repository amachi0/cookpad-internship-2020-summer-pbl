package jp.amachi0.cookpad_internship_2020_summer_pbl.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NutrientsAndFeeling(
    val nutrients: Nutrients,
    val feeling: Feeling
) : Parcelable
