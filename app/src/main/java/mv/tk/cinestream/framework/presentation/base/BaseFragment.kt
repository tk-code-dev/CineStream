package mv.tk.cinestream.framework.presentation.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment: Fragment() {
    private var toast: Toast? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUi()
    }
    abstract fun subscribeUi()
    protected fun showError(msg: String, onRetry: () -> Unit) {
        view?.let {
            toast = Toast.makeText(context, msg, Toast.LENGTH_LONG)
            toast?.show()
        }
    }
}