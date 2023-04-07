package mv.tk.cinestream.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.*

interface ActorsUseCase {
    suspend fun execute(): Flow<Output<ActorResponse>>
    suspend fun execute(id:Int): Flow<Output<ActorDetail>>

}