package mv.tk.cinestream.business.data.network


interface BasePageListResponse<T> {
    var page: Int
    var results: List<T>
}
