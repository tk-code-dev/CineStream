package mv.tk.cinestream.business.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
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