package mv.tk.cinestream.framework.presentation.movie

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mv.tk.cinestream.business.data.remote.MovieDatabaseAPI
import mv.tk.cinestream.business.domain.model.MovieModel
import mv.tk.cinestream.databinding.ItemMoviesBinding
import javax.inject.Singleton

@Singleton
class MovieAdapter(
    private val list: ArrayList<MovieModel>,
    private val onMovieClick: (item: MovieModel) -> Unit
): RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    inner class MovieHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MovieModel) {
            binding.movie = item
            if (item.poster_path!=null) {
                Glide.with(itemView).load(MovieDatabaseAPI.getPosterPath(item.poster_path))
                    .into(binding.imgPoster)
            } else {
            Glide.with(itemView).load(MovieDatabaseAPI.getBackdropUrl(item.backdrop_path))
                .into(binding.imgPoster)
        }
        Log.d(TAG,bindingAdapterPosition.toString())
            binding.position = bindingAdapterPosition
            binding.root.setOnClickListener {
                if(binding.movie!=null){
                onMovieClick.invoke(item)}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMoviesBinding.inflate(inflater, parent, false)
        return MovieHolder(binding)    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun update(newList: List<MovieModel>) {
        list.clear()
        list.addAll(newList)
        Log.d(TAG, "$newList")
        notifyItemRangeChanged(0, list.size)
    }
}