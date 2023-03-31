package mv.tk.cinestream.framework.presentation.actor

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import mv.tk.cinestream.business.domain.model.ActorModel
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.databinding.FragmentActorBinding
import mv.tk.cinestream.framework.presentation.base.BaseFragment
import mv.tk.cinestream.util.Constants.TAG
import javax.inject.Inject

class ActorFragment : BaseFragment() {
    private val actorViewModel: ActorViewModel by activityViewModels()
    private var binding: FragmentActorBinding? = null

    @Inject
    lateinit var actorAdapter: ActorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentActorBinding.inflate(inflater, container, false).let {
        binding = it
        with(it) {
            root
        }
    }

    override fun subscribeUi() {
        binding?.let {
            actorAdapter = ActorAdapter(arrayListOf(), onItemClick)
            it.actorRv.adapter = actorAdapter
        }
        actorViewModel.actorsList.observe(viewLifecycleOwner) { result ->
            when (result.status) {
                Output.Status.SUCCESS -> {
                    result.data?.let { list ->
                        actorAdapter.update(list.results)
                    }
                }
                Output.Status.ERROR -> {
                    result.message?.let {
                        showError(it) {
                        }
                    }
                }
                Output.Status.LOADING -> {}
            }
        }
    }
    private val onItemClick: (movieItem: ActorModel) -> Unit =
        { actor ->
            Log.d(TAG,actor.name)
            navigateToDetail(actor)
        }

    private fun navigateToDetail(actor: ActorModel) {

    }
}