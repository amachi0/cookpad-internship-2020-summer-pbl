package jp.amachi0.cookpad_internship_2020_summer_pbl.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import jp.amachi0.cookpad_internship_2020_summer_pbl.ActivityModule
import jp.amachi0.cookpad_internship_2020_summer_pbl.App
import jp.amachi0.cookpad_internship_2020_summer_pbl.data.local.LocalDataSourceModule
import jp.amachi0.cookpad_internship_2020_summer_pbl.data.repository.RepositoryModule
import jp.amachi0.cookpad_internship_2020_summer_pbl.recipes.RecipesModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ActivityModule::class,
        AndroidInjectionModule::class,
        LocalDataSourceModule::class,
        RepositoryModule::class,
        RecipesModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    override fun inject(app: App)
}

fun Application.createAppComponent() = DaggerAppComponent.factory().create(this)
