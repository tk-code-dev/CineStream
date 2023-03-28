package mv.tk.cinestream.business.domain.model

data class ApiError(
    val statusCode: Int = 0,
    val statusMessage: String? = null
)