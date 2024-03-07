package com.danamon.test.ui.home.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.danamon.core.data.Resource
import com.danamon.core.extension.data
import com.danamon.core.extension.observeData
import com.danamon.domain.model.request.HomeRequest
import com.danamon.test.R
import com.danamon.test.databinding.FragmentHomeBinding
import com.danamon.test.ui.HomeViewModel
import com.danamon.test.ui.home.ui.home.adapter.HomeAdapter
import com.danamon.test.ui.utils.delegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val homeViewModel: HomeViewModel by viewModel()
    private val homeAdapter by lazy {
        HomeAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initview()
        observeData()
    }
    private fun initview() {
        homeViewModel.getHomeData(HomeRequest(page = 1, limit = 10))
        binding.apply {
            homeRv.adapter = homeAdapter
        }
    }

    private fun observeData() {
        observeData(homeViewModel.homeData) { result ->
            result?.let {
                when (it) {
                    is Resource.Success -> {
                        homeAdapter.submitList(result.data())
                    }

                    is Resource.Error -> {

                    }

                    else -> {}
                }
            }
        }
    }
}