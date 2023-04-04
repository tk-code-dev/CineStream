package mv.tk.cinestream.framework.presentation.details.movie

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import mv.tk.cinestream.business.data.remote.MovieDatabaseAPI
import mv.tk.cinestream.business.domain.model.MovieModel
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.databinding.FragmentMovieDetailBinding
import mv.tk.cinestream.framework.presentation.base.BaseFragment
import mv.tk.cinestream.util.Constants.ARG_ITEM
import mv.tk.cinestream.util.Constants.TAG

class MovieDetailFragment : BaseFragment() {

    private val movieDetailViewModel: MovieDetailViewModel by viewModels()
    private var binding: FragmentMovieDetailBinding? = null
    private val movie by lazy {
        Args.fromBundle(arguments)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMovieDetailBinding.inflate(inflater, container, false).let {
        binding = it
        with(it) {
            root
        }
    }

    @SuppressLint("SetTextI18n")
    override fun subscribeUi() {
        Log.d(TAG, movie.movie.id.toString())
        movieDetailViewModel.fetchMovieDetail(movie.movie.id)
        movieDetailViewModel.movieDetail.observe(viewLifecycleOwner) { result ->
            when (result.status) {
                Output.Status.SUCCESS -> {
                    result.data?.let { list ->
                        Log.d(TAG, list.toString())
                        Glide.with(requireView())
                            .load(MovieDatabaseAPI.getBackdropUrl(list.posterPath))
                            .into(binding!!.imgPosterDetail)
                        binding?.run {
                            list.run {
                                itemTitleDetail.text = title
                                itemReleaseDetail.text = "Release: $releaseDate"
                                itemLengthDetail.text = "Length: $runtime min"
                                itemOverviewDetail.text = "Overview: \n$overview"
                                itemRatingBarDetail.numStars = (voteAverage / 2).toInt()
                                itemCountDetail.text = "($voteCount)"
                                itemHomepageDetail.text = homepage
                            }
                        }
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

    class Args(val movie: MovieModel) {
        companion object {
            fun fromBundle(bundle: Bundle?): Args {
                if (bundle == null)
                    throw IllegalStateException("Arguments must be passed to fragment")
                val movie = bundle.getParcelable<MovieModel>(ARG_ITEM)
                    ?: throw IllegalStateException("Entity must be passed as an argument to fragment")
                return Args(movie)
            }
        }

        fun toBundle() = bundleOf(ARG_ITEM to movie)
    }
}