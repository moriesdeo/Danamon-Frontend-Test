package com.danamon.test.ui.home.ui.dashboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.danamon.test.R
import com.danamon.test.databinding.FragmentDashboardBinding
import com.danamon.test.ui.utils.delegate.viewBinding

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {
    private val binding by viewBinding(FragmentDashboardBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}