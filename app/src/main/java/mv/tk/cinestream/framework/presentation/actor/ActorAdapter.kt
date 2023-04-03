package mv.tk.cinestream.framework.presentation.actor

import android.content.ContentValues.TAG
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mv.tk.cinestream.business.data.remote.MovieDatabaseAPI
import mv.tk.cinestream.business.domain.model.ActorModel
import mv.tk.cinestream.databinding.ItemActorsBinding
import javax.inject.Singleton

@Singleton
class ActorAdapter(
    private val list: ArrayList<ActorModel>,
    private val onItemClick: (item: ActorModel) -> Unit
): RecyclerView.Adapter<ActorAdapter.ActorHolder>() {

    inner class ActorHolder(private val binding: ItemActorsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ActorModel) {
            binding.actor = item
            if (item.profile_path!=null) {
                Glide.with(itemView).load(MovieDatabaseAPI.getPosterPath(item.profile_path))
                    .into(binding.imgActor)
            } else {
            Glide.with(itemView).load(MovieDatabaseAPI.getBackdropUrl(item.known_for[0].poster_path))
                .into(binding.imgActor)
        }
        Log.d(TAG,bindingAdapterPosition.toString())
            binding.position = bindingAdapterPosition
            binding.root.setOnClickListener {
                if(binding.actor!=null){
                onItemClick.invoke(item)}
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemActorsBinding.inflate(inflater, parent, false)
        return ActorHolder(binding)    }

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun update(newList: List<ActorModel>) {
        list.clear()
        list.addAll(newList)
        Log.d(TAG, "$newList")
        notifyItemRangeChanged(0, list.size)
    }
}