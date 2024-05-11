package com.example.SmartPark.ui.theme.screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Purple2), ) {

               Box(modifier = Modifier
                   .fillMaxWidth()
                   .size(100.dp)
                   .padding(top = 10.dp)) {
                   Image(painter = painterResource(id = R.drawable.user),
                       contentDescription ="",
                       modifier = Modifier
                           .fillMaxSize()
                           .clip(shape = CircleShape)
                       ,
                   )
               }
        Spacer(modifier = Modifier.height(10.dp))
        var name by remember { mutableStateOf(TextFieldValue("")) }
        var cartype by remember { mutableStateOf(TextFieldValue("")) }
        var phone by remember { mutableStateOf(TextFieldValue("")) }
        var context = LocalContext.current
        Column (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 55.dp)){
            TextField(value = name , onValueChange = {name=it}, placeholder = { Text(text = "enter name", color = Purple2)})
            TextField(value = cartype , onValueChange = {cartype=it}, placeholder = { Text(text = "enter cartype", color = Purple2)})
            TextField(value = phone , onValueChange = {phone=it}, placeholder = { Text(text = "enter phone", color = Purple2)})

        }








    }

}
@Preview(showBackground = true)
@Composable
fun profilescreenpreview(){
    ProfileScreen(rememberNavController())
}