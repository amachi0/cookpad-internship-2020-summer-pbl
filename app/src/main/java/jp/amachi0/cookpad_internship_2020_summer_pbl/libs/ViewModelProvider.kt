package jp.amachi0.cookpad_internship_2020_summer_pbl.libs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun factory(crossinline creator: () -> ViewModel): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return creator() as T
        }
    }
}
