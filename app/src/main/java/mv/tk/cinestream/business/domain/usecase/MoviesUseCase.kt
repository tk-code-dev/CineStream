package mv.tk.cinestream.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.MovieModel
import mv.tk.cinestream.business.domain.model.Output

interface MoviesUseCase {
    suspend fun execute(): Flow<Output<List<MovieModel>>>
}