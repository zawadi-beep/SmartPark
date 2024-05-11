package com.example.SmartPark.ui.theme.screens.valley


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.SmartPark.navigation.DASHBOARD_URL
import com.example.SmartPark.ui.theme.Purple2
import com.example.wazitoecommerce.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun valleyScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Purple2), ) {
        val mContext = LocalContext.current
        //TopAppBar
        TopAppBar(title ={Text(text = "Green Valley", color = Purple2)} ,
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Black),
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate(DASHBOARD_URL)
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription ="arrowback",
                        tint = Purple2
                    )
                }
            },



            )
        Spacer(modifier = Modifier.height(10.dp))
        //end of topappbar

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.park13),
                contentDescription = "car",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp)
            ) {



            }


        }
        Spacer(modifier = Modifier.height(20.dp))
        Box (modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)){
            Column {
                Text(text = "Available Spaces : 12", fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
                Text(text = "Ksh 100 per hour", fontWeight = FontWeight.ExtraBold, fontSize = 40.sp)
            }

        }
        var hours by remember { mutableStateOf(TextFieldValue("")) }
        var cartype by remember { mutableStateOf(TextFieldValue("")) }
        var duration by remember { mutableStateOf(TextFieldValue("")) }
        Column(modifier=Modifier.padding(start=40.dp)) {
            TextField(value = hours , onValueChange = {hours=it}, placeholder = { Text(text = "Specify Hours",color = Color.Black)})


            Spacer(modifier = Modifier.height(20.dp))
            TextField(value = cartype , onValueChange = {cartype=it}, placeholder = { Text(text = "Specify cartype",color = Color.Black)})

            Spacer(modifier = Modifier.height(20.dp))
            TextField(value = duration , onValueChange = {duration=it}, placeholder = { Text(text = "Specify duration",color = Color.Black)})

            Spacer(modifier = Modifier.height(20.dp))
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            OutlinedButton(

                onClick = {
                    val simToolKitLaunchIntent =
                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                    simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                }

            ) {
                Text(text = "Pay")
            }
        }


    }

}
@Preview(showBackground = true)
@Composable
fun valleyscreenpreview(){
    valleyScreen(rememberNavController())
}