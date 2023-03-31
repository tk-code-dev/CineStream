package mv.tk.cinestream.business.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mv.tk.cinestream.business.data.remote.TvsRemoteDataSource
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.model.TvResponse
import mv.tk.cinestream.business.domain.repository.TvsRepository
import javax.inject.Inject

internal class TvsRepositoryImpl @Inject constructor(
    private val tvsRemoteDataSource: TvsRemoteDataSource
) : TvsRepository {
    override suspend fun fetchTvs(): Flow<Output<TvResponse>> {
        return flow {
            emit(Output.loading())
            val result = tvsRemoteDataSource.fetchTvsFromRemote()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}