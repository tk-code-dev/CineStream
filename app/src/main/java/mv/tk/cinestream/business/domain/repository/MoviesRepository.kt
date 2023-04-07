package mv.tk.cinestream.business.domain.repository

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.MovieDetailModel
import mv.tk.cinestream.business.domain.model.MovieResponse
import mv.tk.cinestream.business.domain.model.Output

interface MoviesRepository {
    suspend fun fetchMovies(): Flow<Output<MovieResponse>>
    suspend fun fetchMovieDetail(id:Int): Flow<Output<MovieDetailModel>>
}