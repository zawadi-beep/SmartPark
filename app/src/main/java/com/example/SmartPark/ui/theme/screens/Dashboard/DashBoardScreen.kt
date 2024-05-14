@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.SmartPark.ui.theme.screens.Dashboard


import android.annotation.SuppressLint
import android.content.Intent
import android.provider.Settings
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.SmartPark.navigation.ELGON_URL
import com.example.SmartPark.navigation.FURAHA_URL
import com.example.SmartPark.navigation.GARDEN_URL
import com.example.SmartPark.navigation.GREEN_URL
import com.example.SmartPark.navigation.QUIVER_URL
import com.example.SmartPark.navigation.RALLY_URL
import com.example.SmartPark.navigation.ROUT_ABOUT
import com.example.SmartPark.navigation.ROUT_NOTIFICATION
import com.example.SmartPark.navigation.SALAMA_URL
import com.example.SmartPark.navigation.SAMARA_URL
import com.example.SmartPark.navigation.SARIT_URL
import com.example.SmartPark.navigation.STAREHE_URL
import com.example.SmartPark.navigation.SWARI_URL
import com.example.SmartPark.navigation.TSAVO_URL
import com.example.SmartPark.navigation.UHURU_URL
import com.example.SmartPark.navigation.UPARK_URL
import com.example.SmartPark.navigation.VALLEY_URL
import com.example.SmartPark.ui.theme.Purple2

import com.example.wazitoecommerce.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")

@OptIn( ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun DashBoardScreen(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }
            },



            //Content Section
            content = @Composable{
                val pagerState = rememberPagerState(initialPage = 20)
                val imageSlider = listOf(
                    painterResource(id = R.drawable.park1),
                    painterResource(id = R.drawable.park14),
                    painterResource(id = R.drawable.park15)
                )
                LaunchedEffect(Unit) {
                    while (true) {
                        yield()
                        delay(2600)
                        pagerState.animateScrollToPage(
                            page = (pagerState.currentPage + 1) % (pagerState.pageCount)
                        )
                    }
                }
                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)) {


                    TopAppBar(title = @Composable {


                        Row {
                            Box(modifier = Modifier.size(50.dp)) {
                                Image(
                                    painter = painterResource(id = R.drawable.car),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(shape = CircleShape)
                                )

                            }



                            Text(
                                text = "SmartPark",
                                fontSize = 30.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.Black,
                                modifier = Modifier.padding(start = 20.dp, top = 10.dp)
                            )
                            Spacer(modifier = Modifier.width(20.dp))
                            val mContext = LocalContext.current
                            IconButton(onClick = {  navController.navigate(ROUT_ABOUT)

                            }) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = "Share",
                                    tint = Color.White
                                )
                            }
                            IconButton(onClick = {
                                val settingsIntent = Intent(Settings.ACTION_SETTINGS)
                                mContext.startActivity(settingsIntent)
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Settings,
                                    contentDescription = "Settings",
                                    tint = Color.White
                                )
                            }
                            IconButton(onClick = { navController.navigate(ROUT_NOTIFICATION)}) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = "notification",
                                    tint = Color.White
                                )
                            }
                        }

                    }, colors = TopAppBarDefaults.mediumTopAppBarColors(Purple2))



                  
                    Column(modifier = Modifier.background(Color.White).verticalScroll(rememberScrollState())) {
                        HorizontalPager(
                            count = imageSlider.size,
                            state = pagerState,
                            contentPadding = PaddingValues(horizontal = 10.dp),
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth()
                        ) { page ->
                            Card(
                                shape = RoundedCornerShape(20.dp),
                                modifier = Modifier
                                    .graphicsLayer {
                                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                                        lerp(
                                            start = 0.85f,
                                            stop = 1f,
                                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                        ).also { scale ->
                                            scaleX = scale
                                            scaleY = scale
                                        }

                                        alpha = lerp(
                                            start = 0.5f,
                                            stop = 1f,
                                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                                        )
                                    }
                            ) {
                                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                                    Image(
                                        painter = imageSlider[page],
                                        contentDescription = stringResource(R.string.image_slider),
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                    Text(
                                        text = "Parking smart made simple with our app.",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }
                            }
                        }

                        HorizontalPagerIndicator(
                            pagerState = pagerState,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(20.dp)
                        )



                        Text(
                            text = "Recommended",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(start = 20.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Row(
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .horizontalScroll(rememberScrollState())
                        ) {
                            //column1
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park1),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Uhuru Gardens",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))


                                Text(
                                    text = "From Ksh 100 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {

                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(UHURU_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            //column2
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park2),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Furaha Gardens",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))


                                Text(
                                    text = "From Ksh 150 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(FURAHA_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            //column3
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park3),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Starehe",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "From Ksh 200 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(STAREHE_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            //column4
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park4),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Sarit Mall",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "From Ksh 250 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(SARIT_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            //column5
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park5),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Samara Park",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "From Ksh 130 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(SAMARA_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }


                        }
                        //row2
                        Spacer(modifier = Modifier.height(20.dp))
                        Row {
                            Text(
                                text = "Topliked",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(start = 20.dp)
                            )

                            Spacer(modifier = Modifier.width(10.dp))


                        }

                        Row(
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .horizontalScroll(rememberScrollState())
                        ) {
                            //column1
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park6),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Swari Mall",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))


                                Text(
                                    text = "From Ksh 80 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(SWARI_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            //column2
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park7),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Salama Centre",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))


                                Text(
                                    text = "From Ksh 110 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(SALAMA_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            //column3
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park8),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Green Gardens",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))


                                Text(
                                    text = "From Ksh 100 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(GREEN_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            //column4
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park9),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Garden City",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))

                                Text(
                                    text = "From Ksh 250 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(GARDEN_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            //column5
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park10),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Tsavo Peak",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))


                                Text(
                                    text = "From Ksh 300 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(TSAVO_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }


                        }
                        //row3

                        Spacer(modifier = Modifier.height(20.dp))
                        Row {
                            Text(
                                text = "Others",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier.padding(start = 20.dp)
                            )

                            Spacer(modifier = Modifier.width(10.dp))


                        }


                        Row(
                            modifier = Modifier
                                .padding(start = 10.dp)
                                .horizontalScroll(rememberScrollState())
                        ) {
                            //column1
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park11),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Uhuru Park",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))


                                Text(
                                    text = "From Ksh 50 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(UPARK_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            //column2
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park12),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "Quiver",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))


                                Text(
                                    text = "From Ksh 180 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(QUIVER_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            //column3
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park13),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "GreenValley",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))


                                Text(
                                    text = "From Ksh 230 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(VALLEY_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            //column4
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park14),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "ElgonView",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))


                                Text(
                                    text = "From Ksh 160 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(ELGON_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            //column5
                            Column {
                                Card(
                                    modifier = Modifier
                                        .height(100.dp)
                                        .width(160.dp)
                                ) {
                                    Box(
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.park15),
                                            contentDescription = "New York",
                                            modifier = Modifier.fillMaxSize(),
                                            contentScale = ContentScale.Crop
                                        )
                                        Icon(
                                            imageVector = Icons.Default.FavoriteBorder,
                                            contentDescription = "favorite", tint = Color.White,
                                            modifier = Modifier
                                                .align(Alignment.TopEnd)
                                                .padding(10.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.height(5.dp))
                                Text(
                                    text = "RallyRover",
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily.Serif,

                                    )
                                Spacer(modifier = Modifier.height(5.dp))


                                Text(
                                    text = "From Ksh 190 per hour",
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily.Serif,
                                    color = Color.Blue
                                )
                                Row {
                                    OutlinedButton(

                                        onClick = {
                                            val smsIntent = Intent(Intent.ACTION_SENDTO)
                                            smsIntent.data = "smsto:0700000000".toUri()
                                            smsIntent.putExtra("sms_body", "Hello Glory,how was your day?")

                                        }

                                    ) {
                                        Text(text = "SMS")

                                    }
                                    Spacer(modifier = Modifier.width(5.dp))
                                    OutlinedButton(

                                        onClick = {
                                            navController.navigate(RALLY_URL)
                                        }

                                    ) {
                                        Text(text = "Pay ")
                                    }
                                }
                            }



                        }
                        Column {
                            //Lottie Animation
                            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.a4))
                            val progress by animateLottieCompositionAsState(composition)
                            LottieAnimation(composition, progress,
                                modifier = Modifier.size(400.dp)
                            )

                        }
                    }



                }


            }

        )

    }
 





}
val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Profile",
        route="profile",
        selectedIcon=Icons.Filled.Person,
        unselectedIcon=Icons.Outlined.Person,
        hasNews = true,
        badges=5
    ),
    BottomNavItem(
        title = "New",
        route="view_spaces",
        selectedIcon=Icons.Filled.Star,
        unselectedIcon=Icons.Outlined.Star,
        hasNews = true,
        badges=12
    ),




    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)






@Preview(showBackground = true)
@Composable
fun DashBoardScreenPreview(){
    DashBoardScreen(rememberNavController())
}