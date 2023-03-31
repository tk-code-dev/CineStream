package mv.tk.cinestream.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.ActorModel
import mv.tk.cinestream.business.domain.model.ActorResponse
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.model.TvResponse

interface ActorsUseCase {
    suspend fun execute(): Flow<Output<ActorResponse>>
}