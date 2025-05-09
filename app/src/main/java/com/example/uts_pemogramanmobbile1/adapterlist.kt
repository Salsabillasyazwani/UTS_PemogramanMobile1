package com.example.uts_pemogramanmobbile1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class adapterlist(private val context: Context, private val userList: List<Chatuser>) : BaseAdapter() {

    // Mengembalikan jumlah item dalam userList
    override fun getCount() = userList.size

    // Mengembalikan item di posisi tertentu
    override fun getItem(position: Int) = userList[position]

    // Mengembalikan ID item, bisa menggunakan posisi
    override fun getItemId(position: Int) = position.toLong()

    // Menghubungkan data dengan tampilan (view)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Menyiapkan layout untuk item di dalam ListView
        val view = LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false)

        // Mendapatkan data chat user berdasarkan posisi
        val user = userList[position]

        // Mengatur data ke dalam tampilan
        view.findViewById<TextView>(R.id.nameText).text = user.name
        view.findViewById<TextView>(R.id.lastMessageText).text = user.lastMessage
        view.findViewById<TextView>(R.id.timeText).text = user.time
        view.findViewById<ImageView>(R.id.profileImage).setImageResource(user.profileResId)

        // Mengembalikan tampilan untuk item
        return view
    }
}
