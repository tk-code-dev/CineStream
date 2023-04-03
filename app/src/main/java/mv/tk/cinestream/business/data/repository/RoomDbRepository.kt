package mv.tk.cinestream.business.data.repository

import mv.tk.cinestream.business.data.room.ActorDao
import mv.tk.cinestream.business.data.room.MovieDao
import mv.tk.cinestream.business.data.room.TvDao
import mv.tk.cinestream.business.data.room.entity.ActorDbEntity
import mv.tk.cinestream.business.data.room.entity.MovieDbEntity
import mv.tk.cinestream.business.data.room.entity.TvDbEntity
import javax.inject.Inject

class RoomDbRepository
@Inject constructor(
    private val movieDao: MovieDao,
//    private val tvDao: TvDao,
//    private val actorDao: ActorDao,
) {
    fun insertMovieList(movies: List<MovieDbEntity>) = movieDao.insertMovieList(movies)
    fun updateMovie(movie: MovieDbEntity) = movieDao.updateMovie(movie)
    fun getMovie(id:Int) = movieDao.getMovie(id)
    fun getMovieList(page:Int) = movieDao.getMovieList(page)

//    fun insertTvList(tvs: List<TvDbEntity>) = tvDao.insertTv(tvs)
//    fun updateTv(tv: TvDbEntity) = tvDao.updateTv(tv)
//    fun getTv(id:Int) = tvDao.getTv(id)
//    fun getTvList(page:Int) = tvDao.getTvList(page)
//
//    fun insertActorList(people: List<ActorDbEntity>) = actorDao.insertPeople(people)
//    fun updateActor(actor: ActorDbEntity) = actorDao.updatePerson(actor)
//    fun getActor(id:Int) = actorDao.getPerson(id)
//    fun getActorList(page:Int) = actorDao.getPeople(page)
}