package rx.kotlin.training.rxkotlintraining

import dagger.Component
import javax.inject.Singleton

/**
* Created by davidmartin on 20/9/17.
*/
@Singleton
@Component(modules = arrayOf(Module::class))
interface ApplicationComponent {

    fun inject(application: Application)
    fun inject(mainActivity: View)
}