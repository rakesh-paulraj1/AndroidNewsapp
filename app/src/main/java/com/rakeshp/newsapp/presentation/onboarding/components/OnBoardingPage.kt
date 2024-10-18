package com.rakeshp.newsapp.presentation.onboarding.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.rakeshp.newsapp.presentation.onboarding.Page

@Composable
fun OnBoardingPage(modifier: Modifier = Modifier,page:Page) {
 Column (modifier=modifier){
Image(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.6f), painter = painterResource(id = page.image), contentDescription = null)
 }
}