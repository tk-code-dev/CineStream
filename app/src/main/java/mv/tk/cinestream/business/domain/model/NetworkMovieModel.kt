package mv.tk.cinestream.business.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
//data class MovieResponse(
//    val page: Int,
//    val results: List<MovieModel>,
//    @SerializedName("total_pages")
//    val totalPages: Int,
//    @SerializedName("total_results")
//    val totalResults: Int
//)
//
//data class MovieModel(
//    val adult: Boolean,
//    @SerializedName("backdrop_path")
//    val backdropPath: String?,
//    @SerializedName("genre_ids")
//    val genreIds: List<Int>,
//    val id: Int,
//    @SerializedName("original_language")
//    val originalLanguage: String,
//    @SerializedName("original_title")
//    val originalTitle: String,
//    val overview: String,
//    val popularity: Double,
//    @SerializedName("poster_path")
//    val posterPath: String?,
//    @SerializedName("release_date")
//    val releaseDate: String,
//    val title: String,
//    val video: Boolean,
//    @SerializedName("vote_average")
//    val voteAverage: Double,
//    @SerializedName("vote_count")
//    val voteCount: Int
//)

@Keep
@Parcelize
data class MovieResponse(
//    val page: Int,
    val results: List<MovieModel>,
//    val total_pages: Int,
//    val total_results: Int
): Parcelable

@Keep
@Parcelize
data class MovieModel(
    val adult: Boolean,
    val backdrop_path: String?,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
): Parcelable
