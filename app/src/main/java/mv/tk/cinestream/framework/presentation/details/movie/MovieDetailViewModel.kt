package mv.tk.cinestream.framework.presentation.details.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mv.tk.cinestream.business.domain.model.MovieDetailModel
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.usecase.MovieDetailUseCase
import mv.tk.cinestream.framework.presentation.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val movieDetailUseCase: MovieDetailUseCase) :
    BaseViewModel() {
    private val _movieDetail = MutableLiveData<Output<MovieDetailModel>>()
    val movieDetail: LiveData<Output<MovieDetailModel>> = _movieDetail

    fun fetchMovieDetail(id: Int) {
        viewModelScope.launch {
            movieDetailUseCase.execute(id).collect {
                _movieDetail.value = it
            }
        }
    }
}