package mv.tk.cinestream.framework.presentation.details.actor

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import mv.tk.cinestream.R
import mv.tk.cinestream.util.Constants.TAG

class ActorDetailFragment : Fragment() {

    private lateinit var viewModel: ActorDetailViewModel
    private val args: ActorDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val actorId = args.myInt
        Log.d(TAG,actorId.toString())
        return inflater.inflate(R.layout.fragment_actor_detail, container, false)
    }
}