package mv.tk.cinestream.framework.presentation.details.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mv.tk.cinestream.R
import mv.tk.cinestream.databinding.FragmentMovieDetailBinding
import mv.tk.cinestream.framework.presentation.base.BaseFragment

class MovieDetailFragment : BaseFragment() {

    private lateinit var viewModel: MovieDetailViewModel
    private var binding: FragmentMovieDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View= FragmentMovieDetailBinding.inflate(inflater, container, false).let {
        binding = it
        with(it) {
            root
        }
    }

    override fun subscribeUi() {
        TODO("Not yet implemented")
    }

}