package rx.kotlin.training.rxkotlintraining

import android.app.Application

/**
* Created by davidmartin on 20/9/17.
*/

class Application: Application() {

    companion object {
        @JvmStatic lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        graph = DaggerApplicationComponent.builder().module(Module(this)).build()
        graph.inject(this)
    }
}