package com.example.littlelemon.onboardingscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

@Composable
fun OnBoardingGreeting(){
   val markazi = FontFamily(
       Font(R.font.markazi_text_regular)
   )


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF495E57))
            .padding(vertical = 24.dp,),
            contentAlignment = Alignment.Center
    ){
        Text(
            text = "Let's get to know you",
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = markazi


        )

    }
}

@Preview
@Composable
fun OnBoardingGreetingPreview(){
    OnBoardingGreeting()
}


