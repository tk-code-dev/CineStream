package mv.tk.cinestream.business.domain.usecase

import kotlinx.coroutines.flow.Flow
import mv.tk.cinestream.business.data.repository.RoomDbRepository
import mv.tk.cinestream.business.data.room.entity.MovieDbEntity
import javax.inject.Inject

class RoomDbUseCaseImpl @Inject constructor(private val dbRepository: RoomDbRepository) :
    RoomDbUseCase {

    override suspend fun execute(id: Int): Flow<List<MovieDbEntity>> {
        TODO("Not yet implemented")
    }
}