package com.example.SmartPark.ui.theme.screens.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

import com.example.SmartPark.ui.theme.Purple2
import com.example.wazitoecommerce.R


@Composable
fun AboutScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize().background(Purple2), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        //Lottie Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.a4))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(composition, progress,
            modifier = Modifier.size(400.dp)
        )
        Text(text = "SmartPark provides secure mobile payment options, protecting your financial data during the transaction. In some locations, the app also offers automatic card payments, so you don't have to pull out your phone at all.", fontSize = 20.sp)

    }

}
@Preview(showBackground = true)
@Composable
fun aboutscreenpreview(){
   AboutScreen(rememberNavController())
}