package mv.tk.cinestream.business.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mv.tk.cinestream.business.data.remote.ActorsRemoteDataSource
import mv.tk.cinestream.business.data.remote.TvsRemoteDataSource
import mv.tk.cinestream.business.domain.model.ActorResponse
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.model.TvResponse
import mv.tk.cinestream.business.domain.repository.ActorsRepository
import mv.tk.cinestream.business.domain.repository.TvsRepository
import javax.inject.Inject

internal class ActorsRepositoryImpl @Inject constructor(
    private val actorsRemoteDataSource: ActorsRemoteDataSource
) : ActorsRepository {
    override suspend fun fetchActors(): Flow<Output<ActorResponse>> {
        return flow {
            emit(Output.loading())
            val result = actorsRemoteDataSource.fetchActorsFromRemote()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }
}