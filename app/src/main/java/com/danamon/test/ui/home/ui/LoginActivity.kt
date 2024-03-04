package com.danamon.test.ui.home.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.danamon.core.data.Resource
import com.danamon.core.extension.observeData
import com.danamon.domain.model.request.HomeRequest
import com.danamon.test.R
import com.danamon.test.databinding.ActivityLoginBinding
import com.danamon.test.ui.HomeViewModel
import com.danamon.test.ui.home.MainActivity
import com.danamon.test.ui.utils.delegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityLoginBinding::inflate)
    private val homeViewModel: HomeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initView()
        observe()
    }

    private fun initView() {
        homeViewModel.getHomeData(HomeRequest(page = 1, limit = 10))
        binding.apply {
            btnLogin.setOnClickListener {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
        }
    }

    private fun observe() {
        observeData(homeViewModel.homeData) { result ->
            result?.let {
                when (it) {
                    is Resource.Success -> {

                    }

                    is Resource.Error -> {

                    }

                    else -> {}
                }
            }
        }
    }
}