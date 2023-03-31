package mv.tk.cinestream.framework.presentation.tv

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import mv.tk.cinestream.business.domain.model.Output
import mv.tk.cinestream.business.domain.model.TvModel
import mv.tk.cinestream.databinding.FragmentTvBinding
import mv.tk.cinestream.framework.presentation.base.BaseFragment
import javax.inject.Inject

class TvFragment : BaseFragment() {

    private val tvViewModel: TvViewModel by activityViewModels()
    private var binding: FragmentTvBinding? = null

    @Inject
    lateinit var tvAdapter: TvAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentTvBinding.inflate(inflater, container, false).let {
        binding = it
        with(it) {
            root
        }
    }

    override fun subscribeUi() {
        binding?.let {
            tvAdapter = TvAdapter(arrayListOf(), onItemClick)
            it.tvRv.adapter = tvAdapter
        }
        tvViewModel.tvList.observe(viewLifecycleOwner) { result ->
            when (result.status) {
                Output.Status.SUCCESS -> {
                    result.data?.let { list ->
                        tvAdapter.update(list.results)
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

    private val onItemClick: (tvItem: TvModel) -> Unit =
        { tv ->
            navigateToDetail(tv)
        }

    private fun navigateToDetail(tv: TvModel) {

    }
}