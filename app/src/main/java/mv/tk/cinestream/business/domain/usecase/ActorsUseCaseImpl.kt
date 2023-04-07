package mv.tk.cinestream.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.ActorDetail
import mv.tk.cinestream.business.domain.model.ActorResponse
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.repository.ActorsRepository
import javax.inject.Inject

class ActorsUseCaseImpl @Inject constructor(private val actorsRepository: ActorsRepository) :
    ActorsUseCase {
    override suspend fun execute(): Flow<Output<ActorResponse>> {
        return actorsRepository.fetchActors()
    }
    override suspend fun execute(id: Int): Flow<Output<ActorDetail>> {
        return actorsRepository.fetchActorDetail(id)
    }
}