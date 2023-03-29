package mv.tk.cinestream.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.MovieResponse
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    MoviesUseCase {
        override suspend fun execute():
                Flow<Output<MovieResponse>> {
            return moviesRepository.fetchMovies()
        }
}