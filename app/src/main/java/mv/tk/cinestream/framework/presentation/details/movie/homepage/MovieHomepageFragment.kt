package mv.tk.cinestream.framework.presentation.details.movie.homepage

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import mv.tk.cinestream.databinding.FragmentMovieHomepageBinding

class MovieHomepageFragment : Fragment() {

    private var binding: FragmentMovieHomepageBinding? = null
    private lateinit var webView: WebView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMovieHomepageBinding.inflate(inflater, container, false).let {
        binding = it
        webView = binding?.webView!!
        with(it) {
            root
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homepageUrl = arguments?.getString("URL_HOMEPAGE")
        if (homepageUrl != null) {
            webView.settings.javaScriptEnabled = true
            webView.loadUrl(homepageUrl)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        webView.destroy()
        binding = null
    }
}