package mv.tk.cinestream.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.MovieDetailModel
import mv.tk.cinestream.business.domain.model.MovieResponse
import mv.tk.cinestream.business.domain.model.Output

interface MovieDetailUseCase {
    suspend fun execute(id:Int): Flow<Output<MovieDetailModel>>
}