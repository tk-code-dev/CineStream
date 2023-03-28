package mv.tk.cinestream.business.data.remote

import mv.tk.cinestream.business.data.network.MoviesResponse
import mv.tk.cinestream.business.data.network.TvDiscoverResponse
import mv.tk.cinestream.business.domain.model.Movie
import mv.tk.cinestream.business.domain.model.MovieModel
import mv.tk.cinestream.business.domain.model.MovieResponse
import mv.tk.cinestream.business.domain.model.Person
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

object MovieDatabaseAPI {

    private const val API_VERSION: Int = 3
    private const val BASE_POSTER_URL = "https://image.tmdb.org/t/p/w185"
    private const val BASE_BACKDROP_URL = "https://image.tmdb.org/t/p/w780"
    private const val BASE_PROFILE_URL = "https://image.tmdb.org/t/p/w185"
    private const val BASE_YT_IMG_URL = "https://img.youtube.com/vi/"
    private const val BASE_YT_WATCH_URL = "https://www.youtube.com/watch?v="
    const val BASE_API_URL = "https://api.themoviedb.org/"
    const val MAX_RATING = 10f

    fun getPosterUrl(path: String) = BASE_POSTER_URL + path
    fun getBackdropUrl(path: String) = BASE_BACKDROP_URL + path
    fun getProfileUrl(path: String) = BASE_PROFILE_URL + path
    fun getYoutubeImageUrl(youtubeId: String) = "$BASE_YT_IMG_URL$youtubeId/hqdefault.jpg"
    fun getYoutubeWatchUrl(youtubeId: String) = "$BASE_YT_WATCH_URL$youtubeId"/**/
    fun getRuntimeDateFormat() = ("yyyy-MM-dd")

    interface MovieService {
        @GET("/$API_VERSION/movie/popular")
        fun fetchPopularList(@Query("page") page: Int): Call<MoviesResponse>

        @GET("/$API_VERSION/movie/upcoming")
        fun fetchUpcomingList(@Query("page") page: Int): Call<MoviesResponse>

        @GET("/$API_VERSION/movie/now_playing")
        fun fetchInTheatersList(@Query("page") page: Int): Call<MoviesResponse>

//        @GET("/$API_VERSION/discover/movie")
//        fun fetchDiscoverList(@Query("api_key") apiKey: String): Response<MovieResponse>

        @GET("/3/discover/movie?language=en&sort_by=popularity.desc")
        fun fetchDiscoverList(): Response<List<MovieModel>>

        @GET("/$API_VERSION/movie/{id}")
        fun fetchDetails(@Path("id") id: Int): Response<Movie>
    }

    interface TvService {
        @GET("/$API_VERSION/discover/tv")
        fun fetchDiscoveryList(@Query("page") page: Int): Call<TvDiscoverResponse>
    }

    interface PeopleService {
        @GET("/$API_VERSION/person/{id}")
        fun fetchDetails(@Path("id") id: Int): Call<Person>
    }
}