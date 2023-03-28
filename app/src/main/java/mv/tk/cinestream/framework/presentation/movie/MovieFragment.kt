package mv.tk.cinestream.framework.presentation.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import mv.tk.cinestream.R
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.databinding.FragmentMovieBinding
import mv.tk.cinestream.framework.presentation.base.BaseFragment
import mv.tk.cinestream.util.Constants.TAG

class MovieFragment : BaseFragment() {

    private val movieViewModel: MovieViewModel by activityViewModels()
    private var binding: FragmentMovieBinding? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View = FragmentMovieBinding.inflate(inflater, container, false).let {
        binding = it
        with(it) {
            root
        }
    }

    override fun subscribeUi() {
        movieViewModel.fetchMovies()

        movieViewModel.moviesList.observe(viewLifecycleOwner) { result ->
            when (result.status) {
                Output.Status.SUCCESS -> {
                    result.data?.let { list ->
                        Log.d(TAG,list.toString())
                    }
                    false
                }
                Output.Status.ERROR -> {
                    result.message?.let {
                        showError(it) {
                        }
                    }
                    false
                }
                Output.Status.LOADING -> true
            }
        }

    }
}