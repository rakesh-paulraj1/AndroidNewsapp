package com.rakeshp.newsapp.presentation.common

import android.widget.Button
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NewsButton(modifier: Modifier = Modifier,text:String,onClick:()->Unit) {

    Button(
        onClick=onClick,colors= ButtonDefaults.buttonColors(
            containerColor  = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.surface
    ),
    shape=RoundedCornerShape(size = 6.dp)
        ){

       Text(text=text,style=MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold))
    }
    
}

@Composable
fun NewsTextButton(modifier: Modifier = Modifier,text:String,onClick:()->Unit) {
    TextButton(onClick = onClick) {
        Text(text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = MaterialTheme.colorScheme.surface )
        
    }
}


@Preview(showBackground = true)
@Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES,
    showBackground = true)
@Composable
fun OnBoardingPage(){

   NewsButton(text = "hi") {
       
   }
    NewsTextButton(text = "vanakkam") {
        
    }
}

