package com.example.uts_pemogramanmobbile1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class roomchat : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var messageInput: EditText
    private lateinit var sendButton: Button
    private lateinit var adapter: ChatAdapter
    private val messages = ArrayList<ChatMessage>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_chating)

        listView = findViewById(R.id.chatListView)
        messageInput = findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)

        val customerName = intent.getStringExtra("customerName") ?: "Unknown"

        // Menambahkan pesan awal dari customer
        messages.add(ChatMessage(customerName, "Halo, saya tertarik dengan produk gorden ini", true))

        adapter = ChatAdapter(this, messages)
        listView.adapter = adapter

        sendButton.setOnClickListener {
            val input = messageInput.text.toString().trim()
            if (input.isNotEmpty()) {
                messages.add(ChatMessage("Admin", input, false))
                checkAutoReply(input)
                adapter.notifyDataSetChanged()
                messageInput.text.clear()
                listView.smoothScrollToPosition(messages.size - 1)
            }
        }
    }

    private fun checkAutoReply(input: String) {
        val reply = autoResponses.entries.find { input.lowercase().contains(it.key) }
        reply?.let {
            messages.add(ChatMessage("Admin", it.value, false))
        }
    }

    private val autoResponses = mapOf(
        "gorden" to "Kami memiliki berbagai macam gorden. Ada yang bisa saya bantu lebih lanjut?",
        "halo" to "Halo! Ada yang bisa kami bantu?",
        "harga" to "Harga produk kami mulai dari 100 ribu rupiah."
    )
}
