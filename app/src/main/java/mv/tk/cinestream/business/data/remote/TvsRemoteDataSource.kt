package mv.tk.cinestream.business.data.remote

import mv.tk.cinestream.business.data.services.BaseRemoteDataSource
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.model.TvResponse
import retrofit2.Retrofit
import javax.inject.Inject

class TvsRemoteDataSource @Inject constructor(
    private val apiTvService: MovieDatabaseAPI.TvService, retrofit: Retrofit
) : BaseRemoteDataSource(retrofit) {

    suspend fun fetchTvsFromRemote(): Output<TvResponse> {
        return getResponse(
            request = { apiTvService.fetchDiscoveryList() },
            defaultErrorMessage = "Error fetching Tvs"
        )
    }
}