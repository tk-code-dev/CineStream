package mv.tk.cinestream.business.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class TvResponse(
    val page: Int,
    val results: List<TvModel>,
    val total_pages: Int,
    val total_results: Int
) : Parcelable

@Keep
@Parcelize
data class TvModel(
    val id: Int,
    val name: String,
    val overview: String,
    val poster_path: String?,
    val backdrop_path: String?,
    val first_air_date: String,
    val vote_average: Double,
    val popularity: Double,
    val original_language: String,
    val vote_count: Int,
) : Parcelable

