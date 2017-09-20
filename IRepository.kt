package rx.kotlin.training.rxkotlintraining

import rx.Observable

/**
* Created by davidmartin on 20/9/17.
*/
interface IRepository {
    fun sendMessage(message: String): Observable<String>
}