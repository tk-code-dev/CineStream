package mv.tk.cinestream.framework.presentation.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import mv.tk.cinestream.business.domain.model.MovieModel
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.databinding.FragmentMovieBinding
import mv.tk.cinestream.framework.presentation.base.BaseFragment
import javax.inject.Inject

class MovieFragment : BaseFragment() {

    private val movieViewModel: MovieViewModel by activityViewModels()
    private var binding: FragmentMovieBinding? = null

    @Inject
    lateinit var movieAdapter: MovieAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View = FragmentMovieBinding.inflate(inflater, container, false).let {
        binding = it
        with(it) {
            root
        }
    }
    override fun subscribeUi() {
        binding?.let {
            movieAdapter = MovieAdapter(arrayListOf(), onMovieClick)
            it.movieRv.adapter = movieAdapter
        }
        movieViewModel.moviesList.observe(viewLifecycleOwner) { result ->
            when (result.status) {
                Output.Status.SUCCESS -> {
                    result.data?.let { list ->
//                        Log.d(TAG,list.toString())
                        movieAdapter.update(list.results)
                    }
                }
                Output.Status.ERROR -> {
                    result.message?.let {
                        showError(it) {
                        }
                    }
                }
                Output.Status.LOADING -> {}
            }
        }
    }
    private val onMovieClick: (movieItem: MovieModel) -> Unit =
        { movie ->
            navigateToDetail(movie)
        }

    private fun navigateToDetail(movie: MovieModel) {
        
    }
}