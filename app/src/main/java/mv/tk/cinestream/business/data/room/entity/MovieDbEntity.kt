package mv.tk.cinestream.business.data.room.entity

import android.os.Parcelable
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import mv.tk.cinestream.util.Constants.MOVIE_TABLE

@Parcelize
@Entity(tableName = MOVIE_TABLE, primaryKeys = [("id")])
data class MovieDbEntity(
  var page: Int,
//  var keywords: List<Keyword>? = ArrayList(),
//  var videos: List<Video>? = ArrayList(),
//  var reviews: List<Review>? = ArrayList(),
  val poster_path: String?,
//  val adult: Boolean,
  val overview: String,
  val release_date: String?,
//  val genre_ids: List<Int>,
  val id: Int,
//  val original_title: String,
//  val original_language: String,
  val title: String,
  val backdrop_path: String?,
//  val popularity: Float,
//  val vote_count: Int,
//  val video: Boolean,
//  val vote_average: Float
) : Parcelable
