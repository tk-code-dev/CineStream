package mv.tk.cinestream.framework.presentation.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mv.tk.cinestream.business.domain.model.*
import mv.tk.cinestream.business.domain.usecase.TvsUseCase
import mv.tk.cinestream.framework.presentation.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class TvViewModel @Inject constructor(private val tvsUseCase: TvsUseCase
) :
    BaseViewModel() {

    private val _tvList = MutableLiveData<Output<TvResponse>>()
    val tvList: LiveData<Output<TvResponse>> = _tvList

    init {
        fetchTvs()
    }

    private fun fetchTvs() {
        viewModelScope.launch {
            tvsUseCase.execute().collect {
                _tvList.value = it
            }
        }
    }
}