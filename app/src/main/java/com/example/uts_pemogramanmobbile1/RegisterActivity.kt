package com.example.uts_pemogramanmobbile1

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import android.widget.EditText
import android.app.DatePickerDialog
import java.util.Calendar
import androidx.appcompat.app.AppCompatActivity



class RegisterActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_register)

            val nameInput = findViewById<EditText>(R.id.editName)
            val emailInput = findViewById<EditText>(R.id.editEmail)
            val phoneInput = findViewById<EditText>(R.id.editPhone)
            val passwordInput = findViewById<EditText>(R.id.editPassword)
            val confirmPasswordInput = findViewById<EditText>(R.id.editConfirmPassword)
            val registerButton = findViewById<Button>(R.id.btnRegister)

            registerButton.setOnClickListener {
                val name = nameInput.text.toString().trim()
                val email = emailInput.text.toString().trim()
                val phone = phoneInput.text.toString().trim()
                val password = passwordInput.text.toString()
                val confirmPassword = confirmPasswordInput.text.toString()

                if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty()
                    && password.isNotEmpty() && confirmPassword.isNotEmpty()
                ) {
                    if (password == confirmPassword) {
                        val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                        val editor = sharedPref.edit()

                        if (sharedPref.contains(email)) {
                            Toast.makeText(this, "Email sudah terdaftar", Toast.LENGTH_SHORT).show()
                        } else {
                            editor.putString(email, password)
                            editor.apply()

                            Toast.makeText(this, "Akun berhasil dibuat!", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, login::class.java))
                            finish()
                        }
                    } else {
                        Toast.makeText(this, "Password tidak cocok", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
