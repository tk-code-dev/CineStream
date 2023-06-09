package mv.tk.cinestream.business.data.remote

import mv.tk.cinestream.business.data.services.BaseRemoteDataSource
import mv.tk.cinestream.business.domain.model.ActorDetail
import mv.tk.cinestream.business.domain.model.ActorResponse
import mv.tk.cinestream.business.domain.model.MovieDetailModel
import mv.tk.cinestream.business.domain.model.Output
import retrofit2.Retrofit
import javax.inject.Inject

class ActorsRemoteDataSource @Inject constructor(
    private val apiActorService: MovieDatabaseAPI.ActorService, retrofit: Retrofit
) : BaseRemoteDataSource(retrofit) {

    suspend fun fetchActorsFromRemote(): Output<ActorResponse> {
        return getResponse(
            request = { apiActorService.fetchActors() },
            defaultErrorMessage = "Error fetching Actors"
        )
    }
    suspend fun fetchActorDetailFromRemote(id:Int): Output<ActorDetail> {
        return getResponse(
            request = { apiActorService.fetchDetails(id) },
            defaultErrorMessage = "Error fetching Actors"
        )
    }
}