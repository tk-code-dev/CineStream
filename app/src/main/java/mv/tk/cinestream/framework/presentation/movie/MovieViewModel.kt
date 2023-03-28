package mv.tk.cinestream.framework.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mv.tk.cinestream.business.domain.model.Movie
import mv.tk.cinestream.business.domain.model.MovieModel
import mv.tk.cinestream.business.domain.model.MovieResponse
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.usecase.MoviesUseCase
import mv.tk.cinestream.framework.presentation.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val moviesUseCase: MoviesUseCase
) :
    BaseViewModel() {

    private val _moviesList = MutableLiveData<Output<List<MovieModel>>>()
    val moviesList: LiveData<Output<List<MovieModel>>> = _moviesList

    init {
        fetchMovies()
    }

    fun fetchMovies() {
        viewModelScope.launch {
            moviesUseCase.execute().collect {
                _moviesList.value = it
            }
        }
    }
}