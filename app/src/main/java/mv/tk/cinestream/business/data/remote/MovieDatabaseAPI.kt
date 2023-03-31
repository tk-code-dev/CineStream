package mv.tk.cinestream.business.data.remote

import mv.tk.cinestream.business.domain.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

object MovieDatabaseAPI {

    private const val API_VERSION: Int = 3
    private const val BASE_POSTER_URL = "https://image.tmdb.org/t/p/w185"
    private const val BASE_BACKDROP_URL = "https://image.tmdb.org/t/p/w300"
    private const val BASE_PROFILE_URL = "https://image.tmdb.org/t/p/w185"
    private const val BASE_YT_IMG_URL = "https://img.youtube.com/vi/"
    private const val BASE_YT_WATCH_URL = "https://www.youtube.com/watch?v="
    const val BASE_API_URL = "https://api.themoviedb.org/"
    const val MAX_RATING = 10f

    @JvmStatic
    fun getPosterPath(posterPath: String?): String {
        return BASE_POSTER_URL + posterPath
    }

    @JvmStatic
    fun getBackdropUrl(path: String?): String {
        return BASE_BACKDROP_URL + path
    }

    @JvmStatic
    fun getProfileUrl(path: String) = BASE_PROFILE_URL + path

    @JvmStatic
    fun getYoutubeImageUrl(youtubeId: String) = "$BASE_YT_IMG_URL$youtubeId/hqdefault.jpg"

    @JvmStatic
    fun getYoutubeWatchUrl(youtubeId: String) = "$BASE_YT_WATCH_URL$youtubeId"/**/

    @JvmStatic
    fun getRuntimeDateFormat() = ("yyyy-MM-dd")

    interface MovieService {
        @GET("/$API_VERSION/movie/popular")
        suspend fun fetchPopularList(@Query("page") page: Int): Response<MovieResponse>

        @GET("/$API_VERSION/movie/upcoming")
        suspend fun fetchUpcomingList(@Query("page") page: Int): Response<MovieResponse>

        @GET("/$API_VERSION/movie/now_playing")
        suspend fun fetchInTheatersList(@Query("page") page: Int): Response<MovieResponse>

        @GET("/$API_VERSION/discover/movie?language=en&sort_by=popularity.desc")
        suspend fun fetchDiscoverList(): Response<MovieResponse>

        @GET("/$API_VERSION/movie/{id}")
        suspend fun fetchDetails(@Path("id") id: Int): Response<Movie>
    }

    interface TvService {
        @GET("/$API_VERSION/discover/tv")
        suspend fun fetchDiscoveryList(): Response<TvResponse>
//       TODO: @Query("page") page: Int
    }

    interface ActorService {
        @GET("/$API_VERSION/person/popular")
        suspend fun fetchActors(): Response<ActorResponse>
        @GET("/$API_VERSION/person/{id}")
        suspend fun fetchDetails(@Path("id") id: Int): Response<Person>
    }
}
