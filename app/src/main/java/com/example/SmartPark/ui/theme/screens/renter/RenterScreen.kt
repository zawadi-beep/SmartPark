package com.example.SmartPark.ui.theme.screens.renter

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.SmartPark.data.AuthViewModel
import com.example.SmartPark.navigation.ADD_SPACES_URL
import com.example.SmartPark.navigation.RSIGNUP_URL
import com.example.SmartPark.ui.theme.Purple2
import com.example.wazitoecommerce.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RenterScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(id = R.drawable.car4), contentScale = ContentScale.FillBounds), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

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
        Text(text = "Login here", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold,  color = Purple2)

        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var context = LocalContext.current


        TextField(value = email , onValueChange = {email=it}, placeholder = { Text(text = "enter email", color = Purple2)})
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = password , onValueChange = {password=it}, placeholder = { Text(text = "enter password", color = Purple2)})
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Button(onClick = {
                // HANDLE LOGIN LOGIC //val
                var xyz = AuthViewModel(navController, context)
                xyz.login(email.text,password.text)
                navController.navigate(ADD_SPACES_URL)

            }) {
                Text(text = "Login")
            }

            Button(onClick = {
                navController.navigate(RSIGNUP_URL)
            }) {
                Text(text = "No account? Signup")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RenterScreenPreview() {
    RenterScreen(rememberNavController())
}