package mv.tk.cinestream.framework.presentation.tv

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mv.tk.cinestream.business.data.remote.MovieDatabaseAPI
import mv.tk.cinestream.business.domain.model.TvModel
import mv.tk.cinestream.databinding.ItemTvsBinding
import javax.inject.Singleton

@Singleton
class TvAdapter(
    private val list: ArrayList<TvModel>,
    private val onItemClick: (item: TvModel) -> Unit
): RecyclerView.Adapter<TvAdapter.TvHolder>() {

    inner class TvHolder(private val binding: ItemTvsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: TvModel) {
            binding.tv = item
            if(item.poster_path!=null) {
                Glide.with(itemView).load(MovieDatabaseAPI.getPosterPath(item.poster_path))
                    .into(binding.imgTvPoster)
            } else {
                Glide.with(itemView).load(MovieDatabaseAPI.getBackdropUrl(item.backdrop_path))
                    .into(binding.imgTvPoster)
            }
                Log.d(TAG,bindingAdapterPosition.toString())
            binding.position = bindingAdapterPosition
            binding.root.setOnClickListener {
                if(binding.tv!=null){
                onItemClick.invoke(item)}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTvsBinding.inflate(inflater, parent, false)
        return TvHolder(binding)    }

    override fun onBindViewHolder(holder: TvHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun update(newList: List<TvModel>) {
        list.clear()
        list.addAll(newList)
        Log.d(TAG, "$newList")
        notifyItemRangeChanged(0, list.size)
    }
}