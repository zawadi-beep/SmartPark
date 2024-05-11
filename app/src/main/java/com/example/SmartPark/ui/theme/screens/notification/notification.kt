package com.example.SmartPark.ui.theme.screens.notification


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.SmartPark.ui.theme.Purple2


@Composable
fun notification(navController: NavController){
    Column(modifier = Modifier.fillMaxSize().background(Purple2), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

    }

}
@Preview(showBackground = true)
@Composable
fun aboutscreenpreview(){
    notification(rememberNavController())
}