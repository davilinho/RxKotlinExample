package rx.kotlin.training.rxkotlintraining

import javax.inject.Inject

/**
* Created by davidmartin on 20/9/17.
*/
class Presenter @Inject constructor(private val useCase: UseCase) {

    private var view: IView? = null

    fun sendMessage() {
        view?.let { view ->
            val message = view.getMessage()
            view.showLoading()
            useCase.sendMessage(message!!)
                    .subscribe({ response ->
                        view.showMessage(response)
                        view.hideLoading()
                    }, {
                    })
        }
    }

    fun onViewCreated(view: IView) {
        this.view = view
    }

    fun onViewDestroyed() {
        view = null
    }
}