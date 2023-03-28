package mv.tk.cinestream.business.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import mv.tk.cinestream.business.data.remote.MoviesRemoteDataSource
import mv.tk.cinestream.business.domain.model.MovieModel
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.repository.MoviesRepository
import javax.inject.Inject

internal class MoviesRepositoryImpl @Inject constructor(
    private val moviesRemoteDataSource: MoviesRemoteDataSource
) : MoviesRepository {
    override suspend fun fetchMovies(): Flow<Output<List<MovieModel>>> {
        return flow {
            emit(Output.loading())
            val result = moviesRemoteDataSource.fetchMoviesFromRemote()
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

}