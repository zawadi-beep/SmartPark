package com.example.SmartPark.ui.theme.screens.Space

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.SmartPark.data.SpaceViewModel
import com.example.SmartPark.models.Space

@Composable
fun ViewSpaceScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var spaceRepository = SpaceViewModel(navController, context)


        val emptySpaceState = remember { mutableStateOf(Space("","","","","")) }
        var emptySpaceListState = remember { mutableStateListOf<Space>() }

        var spaces = spaceRepository.allSpaces(emptySpaceState, emptySpaceListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All products",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(spaces){
                    GroceryItem(
                        Spacename = it.name,
                        Spacequantity = it.quantity,
                        Spaceprice = it.price,
                        id = it.id,
                        navController = navController,
                        spaceRepository = spaceRepository,
                        spaceImage = it.imageUrl
                    )
                }
            }
        }
    }
}


@Composable
fun GroceryItem(
    Spacename: String, Spacequantity: String, Spaceprice: String, id: String,
    navController: NavHostController,
     spaceImage: String, spaceRepository: SpaceViewModel
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = Spacename)
        Text(text = Spacequantity)
        Text(text = Spaceprice)
        Image(
            painter = rememberAsyncImagePainter(spaceImage),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
        Button(onClick = {
            spaceRepository.deleteSpace(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            //navController.navigate(ROUTE_UPDATE_PRODUCTS+"/$id")
        }) {
            Text(text = "Update")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ViewspaceScreenPreview(){

        ViewSpaceScreen(navController = rememberNavController())

}