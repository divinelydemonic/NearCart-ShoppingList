package kr.android.shoppinglistapp_room

import android.content.Context
import androidx.room.Room
import kr.android.shoppinglistapp_room.model.ShoppingDatabase
import kr.android.shoppinglistapp_room.model.ShoppingRepository

object Graph {

    //creating database instance
    lateinit var database : ShoppingDatabase

    //loads repository instance only when needed
    val shoppingRepository by lazy {
        ShoppingRepository (shoppingDao = database.shoppingDao())
    }

    //building the database
    fun provide (context: Context) {
//        android.util.Log.d("GRAPH_CHECK", "Initializing database")
        database = Room.databaseBuilder(
            context = context,
            klass = ShoppingDatabase :: class.java,
            name = "shoppinglist.db"
        ).build()
    }

}