package com.dashkevich.home.page1.adapter.model

import com.dashkevich.utility.adapter.Item

class Category(
    val icon: Int,
    val title: String
): Item{

    companion object{

        val list = listOf<Category>(
            Category(
                com.dashkevich.ui.R.drawable.phone_category,
                "Phone"
            ),
            Category(
                com.dashkevich.ui.R.drawable.headphones_category,
                "Headphones"
            ),
            Category(
                com.dashkevich.ui.R.drawable.games_category,
                "Games"
            ),
            Category(
                com.dashkevich.ui.R.drawable.cars_category,
                "Cars"
            ),
            Category(
                com.dashkevich.ui.R.drawable.furniture_category,
                "Furniture"
            ),
            Category(
                com.dashkevich.ui.R.drawable.kids_category,
                "Kids"
            )
        )

    }

}