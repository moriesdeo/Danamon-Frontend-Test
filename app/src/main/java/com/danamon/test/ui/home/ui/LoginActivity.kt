package com.danamon.test.ui.home.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.danamon.core.extension.toast
import com.danamon.test.R
import com.danamon.test.databinding.ActivityLoginBinding
import com.danamon.test.ui.FirebaseHelper
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
    }

    private fun initView() {
        binding.apply {
            btnRegister.setOnClickListener {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
            btnLogin.setOnClickListener {
                when {
                    usernameEdt.text.isBlank() -> {
                        toast("Username tidak boleh kosong")
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
                        FirebaseHelper.getData(
                            username = usernameEdt.text.toString(), onDataChange = {
                                if (usernameEdt.text.toString() == it.name && emailEdt.text.toString() == it.email) {
                                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                                finish()
                            } else {
                                toast("username atau password salah")
                            }
                        }, onCancelled = {
                            toast(it.message)
                        })

                    }
                }
            }
        }
    }
}