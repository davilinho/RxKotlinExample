package rx.kotlin.training.rxkotlintraining

/**
* Created by davidmartin on 20/9/17.
*/

interface IView {
    fun getMessage(): String?
    fun showMessage(message: String)
    fun showLoading()
    fun hideLoading()
}