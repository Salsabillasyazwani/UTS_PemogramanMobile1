package com.example.uts_pemogramanmobbile1

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class daftarchat : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var chatUsers: List<Chatuser>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftarchat)

        listView = findViewById(R.id.listView)

        chatUsers = listOf(
            Chatuser("dodo", "Halo, saya tertarik dengan produk gorden ini", "09:00", R.drawable.profile),
            Chatuser("Salsa ", "Halo, saya tertarik dengan produk gorden ini", "08:30", R.drawable.profile),
            Chatuser("bila ", "Halo, saya tertarik dengan produk gorden ini", "08:15", R.drawable.profile),
            Chatuser("fawaz", "Halo, saya tertarik dengan produk gorden ini", "08:00", R.drawable.profile),
            Chatuser("syazwani", "Halo, saya tertarik dengan produk gorden ini", "07:50", R.drawable.profile),
            Chatuser("lolo", "Halo, saya tertarik dengan produk gorden ini" ,"07:30", R.drawable.profile)

        )

        val adapter = adapterlist(this, chatUsers)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, roomchat::class.java)
            intent.putExtra("customerName", chatUsers[position].name)
            startActivity(intent)
        }
    }
}
