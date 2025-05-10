package com.example.uts_pemogramanmobbile1

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val inputEmail = findViewById<EditText>(R.id.editEmail)
        val inputPassword = findViewById<EditText>(R.id.editPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val signupText = findViewById<TextView>(R.id.btnSignup)


        loginButton.setOnClickListener {
            val email = inputEmail.text.toString().trim()
            val password = inputPassword.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Email harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                Toast.makeText(this, "Password harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Jika admin
            if (email == "Admin" && password == "1234") {
                val intent = Intent(this, daftarchat::class.java)
                startActivity(intent)
                finish()
            } else {
                // Cek di SharedPreferences apakah akun sudah terdaftar
                val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                val savedPassword = sharedPref.getString(email, null)

                if (savedPassword != null && savedPassword == password) {
                    val intent = Intent(this, daftarchat::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Akun tidak ditemukan atau password salah", Toast.LENGTH_SHORT).show()
                }
            }
        }

        signupText.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
