package com.example.wishlistapp.data

import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Keep
@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    @ColumnInfo(name = "wish-title")
    val title: String = "",
    @ColumnInfo(name = "wish-desc")
    val description: String = ""
)

object DummyWish {
    val wishList = listOf(
        Wish(
            title = "asdasdas",
            description = "asdasdasdsa"
        ),
        Wish(
            title = "342343242",
            description = " bvcxvcxvxcv"
        ),
        Wish(
            title = "dffsgsf",
            description = "tg34r2"
        )
    )
}