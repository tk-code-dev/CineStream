package mv.tk.cinestream.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.model.TvResponse

interface TvsUseCase {
    suspend fun execute(): Flow<Output<TvResponse>>
}