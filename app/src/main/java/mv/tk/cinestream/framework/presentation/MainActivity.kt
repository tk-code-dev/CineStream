package mv.tk.cinestream.framework.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import mv.tk.cinestream.R
import mv.tk.cinestream.databinding.ActivityMainBinding
import mv.tk.cinestream.util.Constants.TAG

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            Log.d(TAG,menuItem.toString())

            when (menuItem.itemId) {
                R.id.movieTab -> {
                    findNavController(R.id.nav_host_main).navigate(R.id.movieFragment,null,NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_from_left).setExitAnim(R.anim.slide_to_right).build())
                    true
                }
                R.id.tvTab -> {
                    findNavController(R.id.nav_host_main).navigate(R.id.tvFragment,null,NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_from_left).setExitAnim(R.anim.slide_to_right).build())
                    true
                }
                R.id.actorTab -> {
                    findNavController(R.id.nav_host_main).navigate(R.id.actorFragment,null,NavOptions.Builder()
                        .setEnterAnim(R.anim.slide_from_left).setExitAnim(R.anim.slide_to_right).build())
                    true
                }
                else -> false
            }
        }
    }
}