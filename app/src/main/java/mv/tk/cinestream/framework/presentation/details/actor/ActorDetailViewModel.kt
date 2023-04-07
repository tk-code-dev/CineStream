package mv.tk.cinestream.framework.presentation.details.actor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mv.tk.cinestream.business.domain.model.ActorDetail
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.usecase.ActorsUseCase
import mv.tk.cinestream.framework.presentation.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ActorDetailViewModel  @Inject constructor(private val actorUseCase: ActorsUseCase) :
    BaseViewModel() {
    private val _actorDetail = MutableLiveData<Output<ActorDetail>>()
    val actorDetail: LiveData<Output<ActorDetail>> = _actorDetail

    fun fetchActorDetail(id: Int) {
        viewModelScope.launch {
            actorUseCase.execute(id).collect {
                _actorDetail.value = it
            }
        }
    }
}