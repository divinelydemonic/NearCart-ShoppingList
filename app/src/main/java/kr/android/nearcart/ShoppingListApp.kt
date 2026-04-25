package kr.android.nearcart

import android.app.Application

class ShoppingListApp : Application() {
    //app initialization
    override fun onCreate() {
        super.onCreate()
//        android.util.Log.d("APP_CHECK", "Application onCreate called")
        Graph.provide(this )
    }
}