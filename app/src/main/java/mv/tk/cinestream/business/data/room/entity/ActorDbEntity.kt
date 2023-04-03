package mv.tk.cinestream.business.data.room.entity

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import mv.tk.cinestream.util.Constants.ACTOR_TABLE

@Parcelize
@Entity(tableName = ACTOR_TABLE, primaryKeys = ["id"])
data class ActorDbEntity(
  var page: Int,
  @Embedded var personDetail: ActorDetail? = null,
  val profile_path: String?,
  val adult: Boolean,
  val id: Int,
  val name: String,
  val popularity: Float
) : Parcelable
