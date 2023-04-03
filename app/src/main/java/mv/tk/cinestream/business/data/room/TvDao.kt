package mv.tk.cinestream.business.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import mv.tk.cinestream.business.data.room.entity.TvDbEntity

@Dao
interface TvDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertTv(tvs: List<TvDbEntity>)

  @Update
  fun updateTv(tv: TvDbEntity)

  @Query("SELECT * FROM TV_TABLE WHERE id = :id_")
  fun getTv(id_: Int): TvDbEntity?

  @Query("SELECT * FROM TV_TABLE WHERE page = :page_")
  fun getTvList(page_: Int): List<TvDbEntity>
}
