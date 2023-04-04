package mv.tk.cinestream.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.MovieDetailModel
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.repository.MoviesRepository
import javax.inject.Inject

class MovieDetailUseCaseImpl @Inject constructor(private val moviesRepository: MoviesRepository) :
    MovieDetailUseCase {
    override suspend fun execute(id: Int): Flow<Output<MovieDetailModel>> {
        return moviesRepository.fetchMovieDetail(id)
    }
}