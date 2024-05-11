package com.example.SmartPark.ui.theme.screens.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.SmartPark.navigation.LOGIN_URL
import com.example.SmartPark.navigation.RENTER_URL
import com.example.SmartPark.ui.theme.Purple2
import com.example.wazitoecommerce.R


@Composable
fun Userscreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Purple2), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        val mContext = LocalContext.current

        //Lottie Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.carpark))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(composition, progress,
            modifier = Modifier.size(400.dp)
        )
        Row {
            Card(modifier = Modifier

                .clickable {
                    navController.navigate(LOGIN_URL)

                }
                .size(width = 150.dp,height = 120.dp), ) {
                Column {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp), contentAlignment = Alignment.Center) {
                        Image(painter = painterResource(id = R.drawable.user), contentDescription = "", modifier = Modifier
                            .size(50.dp)
                        )



                    }
                    Text(text = "Log in as user", fontSize = 20.sp,modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

                }

            }

            Spacer(modifier = Modifier.width(20.dp))

            Card(modifier = Modifier
                .clickable {  navController.navigate(RENTER_URL) }

                .size(width = 150.dp,height = 120.dp)) {
                Column {
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp), contentAlignment = Alignment.Center) {
                        Image(painter = painterResource(id = R.drawable.manager), contentDescription = "", modifier = Modifier
                            .size(50.dp)
                        )



                    }
                    Text(text = "Log in as renter", fontSize = 20.sp,modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)

                }

            }


        }

    }



}
@Preview(showBackground = true)
@Composable
fun userscreenpreview(){
    Userscreen(rememberNavController())
}