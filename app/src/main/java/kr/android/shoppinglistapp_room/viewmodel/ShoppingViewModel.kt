package kr.android.shoppinglistapp_room.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kr.android.shoppinglistapp_room.Graph
import kr.android.shoppinglistapp_room.model.ShoppingItem
import kr.android.shoppinglistapp_room.model.ShoppingRepository

class ShoppingViewModel(
    private val shoppingRepository: ShoppingRepository = Graph.shoppingRepository
) : ViewModel() {

    var shoppingItemName by mutableStateOf("")  //item name
    var shoppingItemQuantity by mutableStateOf(0)   //item quantity
    var shoppingItemUnit by mutableStateOf("")  //item quantity  unit


    //updating the item name
    fun updateItemName (newName : String) {
        shoppingItemName = newName
    }

    //updating the item quantity
    fun updateItemQuantity (newQuantity : Int) {
       shoppingItemQuantity = newQuantity
    }

    //updating the item unit
    fun updateItemUnit (newUnit : String) {
        shoppingItemUnit = newUnit
    }


    //adding an item
    fun addItem (shoppingItem: ShoppingItem) {
        viewModelScope.launch (Dispatchers.IO) {
            shoppingRepository.addItem(shoppingItem)
        }
    }

    //updating an item
    fun updateItem (shoppingItem: ShoppingItem){
        viewModelScope.launch (Dispatchers.IO) {
            shoppingRepository.updateItem(shoppingItem)
        }
    }

    //deleting an item
    fun deleteItem (shoppingItem: ShoppingItem) {
        viewModelScope.launch (Dispatchers.IO) {
            shoppingRepository.deleteItem(shoppingItem)
        }
    }

    //get all the items
    val getAllItems : Flow<List<ShoppingItem>> = shoppingRepository.getAllItems()

    //get item by id
    fun getItemById (id : Long) : Flow<ShoppingItem> {
        return shoppingRepository.getItemById(id)
    }

}