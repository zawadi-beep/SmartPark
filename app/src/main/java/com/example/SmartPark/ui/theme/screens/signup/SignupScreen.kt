package com.example.SmartPark.ui.theme.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.SmartPark.data.AdminViewModel
import com.example.SmartPark.data.AuthViewModel
import com.example.SmartPark.navigation.LOGIN_URL
import com.example.SmartPark.ui.theme.Purple2
import com.example.wazitoecommerce.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(id = com.example.wazitoecommerce.R.drawable.car4), contentScale = ContentScale.FillBounds), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

        Row {
            Box(modifier = Modifier.size(50.dp)) {
                Image(painter = painterResource(id = R.drawable.car),
                    contentDescription ="",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = CircleShape))

            }



            Text(
                text = "SmartPark",
                fontSize = 40.sp,color = Color.White,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
        Text(text = "Register here", fontSize = 20.sp, fontWeight = FontWeight.Bold,color = Purple2
        )

        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var name by remember { mutableStateOf(TextFieldValue("")) }

        var context = LocalContext.current



        TextField(value = name , onValueChange = {name=it}, placeholder = { Text(text = "enter name",color = Color.Black)})
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = email , onValueChange = {email=it}, placeholder = { Text(text = "enter email",color = Color.Black)})

        Spacer(modifier = Modifier.height(20.dp))

        TextField(value = password , onValueChange = {password=it}, placeholder = { Text(text = "enter password",color = Color.Black)})

        Spacer(modifier = Modifier.height(20.dp))




        Row {
            val context = LocalContext.current
            val authViewModel = AuthViewModel(navController, context)
            Button(onClick = {
                authViewModel.signup(name, email, password)
            }) {
                Text(text = "Register")
            }

            Button(onClick = {
                navController.navigate(LOGIN_URL)
            }) {
                Text(text = "Have account? Login")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignupScreenPreview() {
    SignupScreen(rememberNavController())
}