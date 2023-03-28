package mv.tk.cinestream.business.data.network

import com.google.gson.annotations.SerializedName
import mv.tk.cinestream.business.data.network.BasePageListResponse
import mv.tk.cinestream.business.domain.model.Movie

data class MoviesResponse(
    @SerializedName("page")
    override var page: Int,

    @SerializedName("results")
    override var results: List<Movie>
) : BasePageListResponse<Movie>