package mv.tk.cinestream.framework.presentation.actor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mv.tk.cinestream.business.domain.model.ActorResponse
import mv.tk.cinestream.business.domain.model.MovieResponse
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.usecase.ActorsUseCase
import mv.tk.cinestream.business.domain.usecase.MoviesUseCase
import mv.tk.cinestream.framework.presentation.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ActorViewModel @Inject constructor(private val actorsUseCase: ActorsUseCase
) :
    BaseViewModel() {

    private val _actorsList = MutableLiveData<Output<ActorResponse>>()
    val actorsList: LiveData<Output<ActorResponse>> = _actorsList

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            actorsUseCase.execute().collect {
                _actorsList.value = it
            }
        }
    }
}