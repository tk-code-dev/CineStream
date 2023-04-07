package mv.tk.cinestream.business.domain.repository

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.*

interface ActorsRepository {
    suspend fun fetchActors(): Flow<Output<ActorResponse>>
    suspend fun fetchActorDetail(id:Int): Flow<Output<ActorDetail>>

}