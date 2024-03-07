package com.danamon.test.ui.home.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.danamon.core.extension.toast
import com.danamon.test.R
import com.danamon.test.databinding.ActivityRegisterBinding
import com.danamon.test.ui.FirebaseHelper
import com.danamon.test.ui.HomeViewModel
import com.danamon.test.ui.utils.delegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.random.Random

class RegisterActivity : AppCompatActivity() {
    private val binding by viewBinding(ActivityRegisterBinding::inflate)
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
    }

    private fun initView() {
        binding.apply {
            btnRegister.setOnClickListener {
                when {
                    usernameEdt.text.isBlank() -> {
                        toast("Username tidak boleh kosong")
                    }

                    roleEdt.text.isBlank() -> {
                        toast("Role tidak boleh kosong")
                    }

                    usernameEdt.text.length == 4 -> {
                        toast("Username Minimal 4 karakter")
                    }

                    emailEdt.text.toString().isBlank() -> {
                        toast("Email tidak boleh kosong")
                    }

                    !homeViewModel.isValidEmail(emailEdt.text.toString()) -> {
                        toast("Email tidak valid")
                    }

                    else -> {
                        FirebaseHelper.setData(
                            usernameEdt.text.toString(),
                            emailEdt.text.toString(),
                            roleEdt.text.toString(),
                            Random.nextInt(1, 1000)
                        )
                        finish()
                    }
                }
            }
        }
    }
}