package com.danamon.test.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.danamon.core.extension.visible
import com.danamon.test.R
import com.danamon.test.databinding.ActivityMainBinding
import com.danamon.test.ui.utils.delegate.viewBinding

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private lateinit var navHostFragment: NavHostFragment
    private val navController by lazy { navHostFragment.navController }

    private val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
        when (destination.id) {
            R.id.navigation_home, R.id.navigation_dashboard -> binding.navView.visible(
                true
            )

            else -> binding.navView.visible(false)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        binding.navView.apply {
            itemIconTintList = null
            setupWithNavController(navController)
        }
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        super.onPause()
        navController.removeOnDestinationChangedListener(listener)
    }
}