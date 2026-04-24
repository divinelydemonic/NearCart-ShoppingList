package kr.android.shoppinglistapp_room

import android.app.Application
import android.util.Log

class ShoppingListApp : Application() {
    //app initialization
    override fun onCreate() {
        super.onCreate()
//        android.util.Log.d("APP_CHECK", "Application onCreate called")
        Graph.provide(this )
    }
}