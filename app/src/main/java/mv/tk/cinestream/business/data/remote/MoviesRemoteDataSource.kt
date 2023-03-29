package mv.tk.cinestream.business.data.remote

import mv.tk.cinestream.business.data.services.BaseRemoteDataSource
import mv.tk.cinestream.business.domain.model.MovieModel
import mv.tk.cinestream.business.domain.model.MovieResponse
import mv.tk.cinestream.business.domain.model.Output
import retrofit2.Retrofit
import javax.inject.Inject

class MoviesRemoteDataSource @Inject constructor(
    private val apiService: MovieDatabaseAPI.MovieService, retrofit: Retrofit
) : BaseRemoteDataSource(retrofit) {

    suspend fun fetchMoviesFromRemote(): Output<MovieResponse> {
        return getResponse(
            request = { apiService.fetchDiscoverList() },
            defaultErrorMessage = "Error fetching Movies"
        )
    }
}