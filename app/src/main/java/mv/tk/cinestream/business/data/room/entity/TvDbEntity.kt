package mv.tk.cinestream.business.data.room.entity

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import mv.tk.cinestream.util.Constants.TV_TABLE

@Parcelize
@Entity(tableName = TV_TABLE, primaryKeys = [("id")])
data class TvDbEntity(
  var page: Int,
//  var keywords: List<Keyword>? = emptyList(),
//  var videos: List<Video>? = emptyList(),
//  var reviews: List<Review>? = emptyList(),
  val poster_path: String?,
  val popularity: Float,
  val id: Int,
  val backdrop_path: String?,
  val vote_average: Float,
  val overview: String,
  val first_air_date: String?,
//  val origin_country: List<String>,
//  val genre_ids: List<Int>,
  val original_language: String,
  val vote_count: Int,
  val name: String,
  val original_name: String
) : Parcelable
