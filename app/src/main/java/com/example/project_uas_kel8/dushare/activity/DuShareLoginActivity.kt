package com.example.project_uas_kel8.dushare.activity

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_uas_kel8.R
import com.example.project_uas_kel8.databinding.ActivityDushareLoginBinding

class DuShareLoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDushareLoginBinding
    private var isPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDushareLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.loginMain) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnBack.setOnClickListener {
            finish()
        }

        // Toggle password visibility
        binding.btnTogglePassword.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                binding.edtPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                binding.btnTogglePassword.setImageResource(R.drawable.ic_dushare_visibility_off)
            } else {
                binding.edtPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                binding.btnTogglePassword.setImageResource(R.drawable.ic_dushare_visibility)
            }
            binding.edtPassword.setSelection(binding.edtPassword.text.length)
        }

        // Login Action
        binding.btnLogin.setOnClickListener {
            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.edtEmail.error = "Silakan masukkan email mahasiswa"
                binding.edtEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.edtPassword.error = "Silakan masukkan password"
                binding.edtPassword.requestFocus()
                return@setOnClickListener
            }

            if (email != password) {
                binding.edtPassword.error = "Email dan password harus sama!"
                Toast.makeText(this, "Login gagal: Email dan password harus sama", Toast.LENGTH_SHORT).show()
                binding.edtPassword.requestFocus()
                return@setOnClickListener
            }

            // Save login session
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putBoolean("isLogin", true)
            editor.putString("email", email)
            editor.putString("username", email.substringBefore("@"))
            editor.apply()

            Toast.makeText(this, "Login Berhasil! Selamat Datang di EduShare", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, DuShareMainActivity::class.java))
            finish()
        }

        // Google Sign In Mock
        binding.btnGoogleSignIn.setOnClickListener {
            val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
            sharedPref.edit()
                .putBoolean("isLogin", true)
                .putString("email", "andrew@mahasiswa.ui.ac.id")
                .putString("username", "Andrew Pratama")
                .apply()

            Toast.makeText(this, "Masuk dengan akun Google Kampus", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, DuShareMainActivity::class.java))
            finish()
        }

        binding.txtForgotPassword.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Lupa Password")
                .setMessage("Tautan reset password telah dikirim ke email mahasiswa Anda.")
                .setPositiveButton("OK", null)
                .show()
        }

        binding.txtRegister.setOnClickListener {
            Toast.makeText(this, "Halaman Pendaftaran Mahasiswa", Toast.LENGTH_SHORT).show()
        }
    }
}
