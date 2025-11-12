package com.example.littlelemon.onboardingscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemon.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun OnBoardingHeader(
    modifier: Modifier = Modifier,
    logoResId: Int = R.drawable.logo
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(96.dp)
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = logoResId),
            contentDescription = "Little Lemon Logo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 17.dp)
                .size(96.dp),
            contentScale = ContentScale.FillWidth
        )
    }
}



@Preview(showBackground = true)
@Composable
fun OnBoardingHeaderPreview() {
    OnBoardingHeader(logoResId = R.drawable.logo)
}


