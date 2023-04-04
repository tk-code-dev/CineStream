package mv.tk.cinestream.business.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import mv.tk.cinestream.business.data.room.entity.MovieDbEntity

@Keep
@Parcelize
data class MovieDetailModel(
    val adult: Boolean,
    val backdrop_path: String?,
    val homepage:String?,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String?,
    val release_date: String,
    val revenue:Int,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
) : Parcelable
