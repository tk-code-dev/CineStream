package mv.tk.cinestream.framework.presentation.details.movie.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import mv.tk.cinestream.databinding.FragmentMovieHomepageBinding

class MovieHomepageFragment : Fragment() {

    private var binding: FragmentMovieHomepageBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMovieHomepageBinding.inflate(inflater, container, false).let {
        binding = it
        with(it) {
            root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homepageUrl = arguments?.getString("URL_HOMEPAGE")
        if (homepageUrl != null) {
            binding?.webView?.loadUrl(homepageUrl)
        }
    }
}