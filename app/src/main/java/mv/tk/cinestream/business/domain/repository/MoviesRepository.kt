package mv.tk.cinestream.business.domain.repository

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.Movie
import mv.tk.cinestream.business.domain.model.MovieModel
import mv.tk.cinestream.business.domain.model.MovieResponse
import mv.tk.cinestream.business.domain.model.Output

interface MoviesRepository {
    suspend fun fetchMovies(): Flow<Output<List<MovieModel>>>
}