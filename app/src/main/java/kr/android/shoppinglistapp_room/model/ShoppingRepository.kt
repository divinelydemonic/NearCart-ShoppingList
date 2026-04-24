package kr.android.shoppinglistapp_room.model

import kotlinx.coroutines.flow.Flow

class ShoppingRepository (private val shoppingDao: ShoppingDao) {

    suspend fun addItem(shoppingItem : ShoppingItem){ shoppingDao.addItem(shoppingItem ) }

    suspend fun updateItem(shoppingItem: ShoppingItem){ shoppingDao.updateItem(shoppingItem) }

    suspend fun deleteItem(shoppingItem: ShoppingItem){ shoppingDao.deleteItem(shoppingItem) }

    fun getAllItems() : Flow<List<ShoppingItem>> = shoppingDao.getAllItems()

    fun getItemById(id : Long) : Flow<ShoppingItem> = shoppingDao.getItemById(id)

}