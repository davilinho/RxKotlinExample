package rx.kotlin.training.rxkotlintraining

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
* Created by davidmartin on 20/9/17.
*/
class UseCase @Inject constructor(private val repository: IRepository) {
    fun sendMessage(message: String): Observable<String> {
        return repository.sendMessage(message).observeOn(AndroidSchedulers.mainThread())
    }
}