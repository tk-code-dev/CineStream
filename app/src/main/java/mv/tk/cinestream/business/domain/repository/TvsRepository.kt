package mv.tk.cinestream.business.domain.repository

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.domain.model.*

interface TvsRepository {
    suspend fun fetchTvs(): Flow<Output<TvResponse>>
}