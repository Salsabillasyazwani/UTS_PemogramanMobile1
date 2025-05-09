package com.example.uts_pemogramanmobbile1

data class ChatMessage (
    val sender: String,  // Admin, Bot, atau Customer
    val message: String,
    val isFromCustomer: Boolean = false

)
