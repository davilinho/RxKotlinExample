package rx.kotlin.training.rxkotlintraining

import rx.Observable
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
* Created by davidmartin on 20/9/17.
*/
class Repository @Inject constructor() : IRepository {
    override fun sendMessage(message: String): Observable<String> {
        return rx.Observable.create(rx.Observable.OnSubscribe<String> { subscriber ->
            //Transaction or network imitation
            Thread.sleep(2000)
            subscriber.onNext(message + " kotlineado.")
        }).subscribeOn(Schedulers.io())
    }
}