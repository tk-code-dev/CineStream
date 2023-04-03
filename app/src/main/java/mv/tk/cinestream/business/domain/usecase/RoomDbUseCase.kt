package mv.tk.cinestream.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.data.room.entity.MovieDbEntity

interface RoomDbUseCase {
    suspend fun execute(id: Int): Flow<List<MovieDbEntity>>
}