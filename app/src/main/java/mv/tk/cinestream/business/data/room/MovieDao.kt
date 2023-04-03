/*
 * Designed and developed by 2019 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mv.tk.cinestream.business.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import mv.tk.cinestream.business.data.room.entity.MovieDbEntity

@Dao
interface MovieDao {
  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertMovieList(movies: List<MovieDbEntity>)

  @Update
  fun updateMovie(movie: MovieDbEntity)

  @Query("SELECT * FROM MOVIE_TABLE WHERE id = :id_")
  fun getMovie(id_: Int): MovieDbEntity

  @Query("SELECT * FROM MOVIE_TABLE WHERE page = :page_")
  fun getMovieList(page_: Int): List<MovieDbEntity>
}
