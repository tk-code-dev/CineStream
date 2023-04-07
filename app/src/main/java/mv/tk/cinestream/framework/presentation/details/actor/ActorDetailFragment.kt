package mv.tk.cinestream.framework.presentation.details.actor

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import mv.tk.cinestream.business.data.remote.MovieDatabaseAPI
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.databinding.FragmentActorDetailBinding
import mv.tk.cinestream.framework.presentation.base.BaseFragment
import mv.tk.cinestream.util.Constants.TAG
import kotlin.properties.Delegates

class ActorDetailFragment : BaseFragment() {

    private val actorDetailViewModel: ActorDetailViewModel by viewModels()
    private val args: ActorDetailFragmentArgs by navArgs()
    private var actorId by Delegates.notNull<Int>()
    private var binding: FragmentActorDetailBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentActorDetailBinding.inflate(inflater, container, false).let {
        binding = it
        actorId = args.myInt
        Log.d(TAG, actorId.toString())
        with(it) {
            root
        }
    }

    override fun subscribeUi() {
        actorDetailViewModel.fetchActorDetail(actorId)
        actorDetailViewModel.actorDetail.observe(viewLifecycleOwner) { result ->
            when (result.status) {
                Output.Status.SUCCESS -> {
                    result.data?.let { list ->
                        Log.d(TAG, list.toString())
                        Glide.with(requireView())
                            .load(MovieDatabaseAPI.getProfileUrl(list.profilePath!!))
                            .into(binding!!.imgPosterDetailActor)
                        binding?.run {
                            list.run {
                                itemTitleDetailActor.text = name
                                if (deathday == null) {
                                    itemBirthdayDetailActor.text = "($birthday - )"
                                } else {
                                    itemBirthdayDetailActor.text = "($birthday - $deathday)"
                                }
                                itemBiographyDetailActor.text = "Biography: \n$biography"
                                itemPopularityDetailActor.numStars = (popularity!!.toInt() / 2)
                                if (placeOfBirth != null) {
                                    itemPlaceOfBirthDetailActor.text = "Place of Birth: $placeOfBirth"
                                }
                                itemHomepageDetailActor.text = homepage
                            }
                        }
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

}