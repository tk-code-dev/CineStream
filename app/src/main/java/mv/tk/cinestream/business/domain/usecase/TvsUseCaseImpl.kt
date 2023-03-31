package mv.tk.cinestream.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.model.TvResponse
import mv.tk.cinestream.business.domain.repository.TvsRepository
import javax.inject.Inject

class TvsUseCaseImpl @Inject constructor(private val tvsRepository: TvsRepository) :
    TvsUseCase {
        override suspend fun execute():
                Flow<Output<TvResponse>> {
            return tvsRepository.fetchTvs()
        }
}