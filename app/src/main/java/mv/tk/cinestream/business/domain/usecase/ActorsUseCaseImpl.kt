package mv.tk.cinestream.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.ActorModel
import mv.tk.cinestream.business.domain.model.ActorResponse
import mv.tk.cinestream.business.domain.model.MovieResponse
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.repository.ActorsRepository
import mv.tk.cinestream.business.domain.repository.MoviesRepository
import javax.inject.Inject

class ActorsUseCaseImpl @Inject constructor(private val actorsRepository: ActorsRepository) :
    ActorsUseCase {
        override suspend fun execute():
                Flow<Output<ActorResponse>> {
            return actorsRepository.fetchActors()
        }
}