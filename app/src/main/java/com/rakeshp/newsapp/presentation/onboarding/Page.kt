package com.rakeshp.newsapp.presentation.onboarding

 import androidx.annotation.DrawableRes
 import com.rakeshp.newsapp.R

data class Page(
    val title:String,
    val description: String,
    @DrawableRes val image:Int
)
val pages= listOf(
    Page(
        title="page 1",
        description = "1",
        image= R.drawable.onboarding1
    ), Page(
        title="2",
        description = "2",
        image=R.drawable.onboarding1
    ),
    Page(
        title="3",
        description = "3",
        image=R.drawable.onboarding1
    )

)

