package mv.tk.cinestream.framework.presentation.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import mv.tk.cinestream.R
import mv.tk.cinestream.business.domain.model.MovieModel
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.databinding.FragmentMovieBinding
import mv.tk.cinestream.framework.presentation.base.BaseFragment
import mv.tk.cinestream.framework.presentation.details.movie.MovieDetailFragment
import javax.inject.Inject

class MovieFragment : BaseFragment() {

    private val movieViewModel: MovieViewModel by activityViewModels()
    private var binding: FragmentMovieBinding? = null

    @Inject
    lateinit var movieAdapter: MovieAdapter

    private lateinit var navController: NavController

//    @Inject
//    lateinit var repository: RoomDbRepository
//
//    @Inject
//    lateinit var movie: MovieDbEntity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentMovieBinding.inflate(inflater, container, false).let {
        binding = it
        navController = findNavController()
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
//                    val movies = result.data?.results?.map { it ->
//                        MovieDbEntity(
//                            page = 1,
//                            id = it.id,
//                            title = it.title,
//                            backdrop_path = it.backdrop_path,
//                            overview = it.overview,
//                            poster_path = it.poster_path,
//                            release_date = it.release_date,
//                            )
//                    }
//                    movies?.let{repository.insertMovieList(it)}

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
        navController.navigate(
            R.id.action_movieFragment_to_movieDetailFragment,
            MovieDetailFragment.Args(movie).toBundle(),
            null
        )
    }

//    fun movieModelToDbEntity(movieModel: MovieModel): MovieDbEntity {
//        return MovieDbEntity(
//            id = movieModel.id,
//            title = movieModel.title,
//            adult = movieModel.adult,
//            backdrop_path = movieModel.backdrop_path,
////    val genre_ids: List<Int>,
//            original_language = movieModel.original_language,
//            original_title = movieModel.original_title,
//            overview = movieModel.overview,
////     popularity = movieModel.popularity,
//            poster_path = movieModel.poster_path,
//            release_date = movieModel.release_date,
//
//            video = movieModel.video,
////   vote_average = movieModel.vote_average,
//            vote_count = movieModel.vote_count
//        )
//    }

//    fun mapToDbEntity(
//        id: Int,
//        page: Int,
//        title: String,
//        overview: String,
//        posterPath: String?,
//        releaseDate: String?,
//        backdropPath:String?
//    ): MovieDbEntity {
//        return MovieDbEntity(
//            id = id,
//            page = page,
//            title = title,
//            overview = overview,
//            poster_path = posterPath,
//            release_date = releaseDate,
//            backdrop_path = backdropPath
//        )
//    }

}