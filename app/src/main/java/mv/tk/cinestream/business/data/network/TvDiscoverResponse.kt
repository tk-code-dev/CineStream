package mv.tk.cinestream.business.data.network

import com.google.gson.annotations.SerializedName
import mv.tk.cinestream.business.domain.model.TvShow

data class TvDiscoverResponse(
    @SerializedName("page")
    override var page: Int,

    @SerializedName("results")
    override var results: List<TvShow>
) : BasePageListResponse<TvShow>