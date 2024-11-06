package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.WishDatabase
import com.example.wishlistapp.data.WishRepository

object Graph {
    lateinit var wishDatabase: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = wishDatabase.wishDao())
    }

    fun provide(context: Context){
        wishDatabase = Room.databaseBuilder(
            context = context,
            klass = WishDatabase::class.java,
            name = "wishlist.db"
        ).build()
    }
}