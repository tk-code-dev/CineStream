package mv.tk.cinestream.business.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import mv.tk.cinestream.business.data.room.entity.ActorDbEntity

@Dao
interface ActorDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertPeople(people: List<ActorDbEntity>)

  @Update
  fun updatePerson(person: ActorDbEntity)

  @Query("SELECT * FROM ACTOR_TABLE WHERE id = :id_")
  fun getPerson(id_: Int): ActorDbEntity

  @Query("SELECT * FROM ACTOR_TABLE WHERE page = :page_")
  fun getPeople(page_: Int): List<ActorDbEntity>
}
