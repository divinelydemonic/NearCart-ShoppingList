package kr.android.shoppinglistapp_room.model

import kotlinx.coroutines.flow.Flow

class ShoppingRepository (private val shoppingDao: ShoppingDao) {

    suspend fun addItem(shoppingEntity : ShoppingItem){ shoppingDao.addItem(shoppingEntity ) }

    suspend fun updateItem(shoppingEntity: ShoppingItem){ shoppingDao.updateItem(shoppingEntity) }

    suspend fun deleteItem(shoppingEntity: ShoppingItem){ shoppingDao.deleteItem(shoppingEntity) }

    suspend fun getAllItems() : Flow<List<ShoppingItem>> = shoppingDao.getAllItems()

    suspend fun getItemById(id : Long) : Flow<ShoppingItem> = shoppingDao.getItemById(id)

}