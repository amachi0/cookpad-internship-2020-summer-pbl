package jp.amachi0.cookpad_internship_2020_summer_pbl

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import jp.amachi0.cookpad_internship_2020_summer_pbl.di.AppComponent
import jp.amachi0.cookpad_internship_2020_summer_pbl.di.createAppComponent

class App : DaggerApplication() {

    val appComponent: AppComponent by lazy {
        createAppComponent()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent
    }
}