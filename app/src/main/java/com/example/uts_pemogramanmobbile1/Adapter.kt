package com.example.uts_pemogramanmobbile1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ChatAdapter(private val context: Context, private val messages: ArrayList<ChatMessage>) : BaseAdapter() {

    override fun getCount(): Int = messages.size

    override fun getItem(position: Int): Any = messages[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val message = messages[position]
        val view: View
        val inflater = LayoutInflater.from(context)

        view = if (message.isFromCustomer) {
            inflater.inflate(R.layout.chat_customer, parent, false)
        } else {
            inflater.inflate(R.layout.chat_admin, parent, false)
        }

        val profileImage = view.findViewById<ImageView>(R.id.profileImage)
        val messageText = view.findViewById<TextView>(R.id.messageText)
        val nameText = view.findViewById<TextView>(R.id.nameText)

        messageText.text = message.message
        nameText.text = message.sender

        return view
    }
}
