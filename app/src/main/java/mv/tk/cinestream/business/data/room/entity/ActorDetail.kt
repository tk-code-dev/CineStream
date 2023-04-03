package mv.tk.cinestream.business.data.room.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ActorDetail(
  val birthday: String?,
  val known_for_department: String,
  val place_of_birth: String?,
//  val also_known_as: List<String>?,
  val biography: String
) : Parcelable