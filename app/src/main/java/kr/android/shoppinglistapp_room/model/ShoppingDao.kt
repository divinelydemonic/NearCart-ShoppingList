package kr.android.shoppinglistapp_room.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ShoppingDao {

    //adding shopping item
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addItem(shoppingEntity : ShoppingItem)  : Long

    @Update
    suspend fun updateItem(shoppingEntity: ShoppingItem) : Int

    @Delete
    suspend fun deleteItem(shoppingEntity: ShoppingItem) : Int

    @Query("select * from `shopping_table`")
    suspend fun getAllItems() : Flow<List<ShoppingItem>>

    @Query("select * from `shopping_table` where id = :id")
    suspend fun getItemById(id : Long) : Flow<ShoppingItem>


}