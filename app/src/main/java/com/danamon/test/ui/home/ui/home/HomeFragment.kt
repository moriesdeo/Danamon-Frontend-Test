package com.danamon.test.ui.home.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.danamon.test.R
import com.danamon.test.databinding.FragmentHomeBinding
import com.danamon.test.ui.HomeViewModel
import com.danamon.test.ui.utils.delegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initview()
    }

    private fun initview() {

    }
}