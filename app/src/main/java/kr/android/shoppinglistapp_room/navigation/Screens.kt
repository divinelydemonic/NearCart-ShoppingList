package kr.android.shoppinglistapp_room.navigation

sealed class Screens(val route : String) {
    object HomeScreen : Screens("homeScreen")
    object AddEditScreen : Screens("addEditScreen")
}