package com.example.wishlistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addWish(wishEntity: Wish)

    @Query("Select * From `wish-table` ")
    abstract fun getAllWishes(): Flow<List<Wish>>

    @Delete
    abstract suspend fun deleteWish(wishEntity: Wish)

    @Query("Select * From `wish-table` where id = :id ")
    abstract fun getWishById(id: Long): Flow<Wish>

    @Update
    abstract suspend fun updateWish(wishEntity: Wish)
}