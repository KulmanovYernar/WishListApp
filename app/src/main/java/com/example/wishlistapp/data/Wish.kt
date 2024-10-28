package com.example.wishlistapp.data

import androidx.annotation.Keep

@Keep
data class Wish(
    val id: Long = 0L,
    val title: String = "",
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