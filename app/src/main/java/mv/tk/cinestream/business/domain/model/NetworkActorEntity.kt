package mv.tk.cinestream.business.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class ActorResponse(
    val page: Int,
    val results: List<ActorModel>,
    val total_pages: Int,
    val total_results: Int
): Parcelable

@Keep
@Parcelize
data class ActorModel(
    val profile_path: String?,
    val adult: Boolean,
    val id: Int,
    val known_for: List<ActorMovie>,
    val name: String,
    val popularity: Double
) : Parcelable

@Keep
@Parcelize
data class ActorMovie(
    val poster_path: String?,
    val adult: Boolean,
    val overview: String,
    val release_date: String,
    val original_title: String,
    val genre_ids: List<Int>,
    val id: Int,
    val media_type: String,
    val original_language: String,
    val title: String,
    val backdrop_path: String?,
    val popularity: Double,
    val vote_count: Int,
    val video: Boolean,
    val vote_average: Double
): Parcelable

@Parcelize
data class ActorDetail(
    @SerializedName("birthday")
    val birthday: String?,
    @SerializedName("known_for_department")
    val knownForDepartment: String?,
    @SerializedName("deathday")
    val deathday: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("also_known_as")
    val alsoKnownAs: List<String>?,
    @SerializedName("gender")
    val gender: Int?,
    @SerializedName("biography")
    val biography: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("place_of_birth")
    val placeOfBirth: String?,
    @SerializedName("profile_path")
    val profilePath: String?,
    @SerializedName("adult")
    val adult: Boolean?,
    @SerializedName("imdb_id")
    val imdbId: String?,
    @SerializedName("homepage")
    val homepage: String?
) : Parcelable