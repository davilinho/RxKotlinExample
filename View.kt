package rx.kotlin.training.rxkotlintraining

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@SuppressLint("Registered")
/**
* Created by davidmartin on 20/9/17.
*/
class View: AppCompatActivity(), IView {

    @Inject
    lateinit var presenter: Presenter

    var progressDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Application.graph.inject(this)

        presenter.onViewCreated(this)

        button.setOnClickListener {
            presenter.sendMessage()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    override fun showMessage(message: String) {
        input.text.clear()
        output.text = message
    }

    override fun getMessage(): String? {
        return input.text.toString()
    }

    override fun showLoading() {
        progressDialog = ProgressDialog(this)
        progressDialog!!.setMessage("Loading, please wait..")
        progressDialog!!.show()
    }

    override fun hideLoading() {
        progressDialog!!.dismiss()
    }
}
