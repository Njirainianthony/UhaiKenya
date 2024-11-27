package com.example.antoproject.ui.theme.screens.nurses

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.antoproject.R
import com.example.antoproject.data.NurseViewModel
import com.example.antoproject.models.Nurse
import com.example.antoproject.navigation.ADD_NURSES_URL
import com.example.antoproject.ui.theme.Bluey

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ViewNursesScreen2(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Bluey)) {

        var context = LocalContext.current
        var nurseRepository = NurseViewModel(navController, context)


        val emptyNurseState = remember { mutableStateOf(Nurse("","","")) }
        var emptyNurseListState = remember { mutableStateListOf<Nurse>() }

        var nurses = nurseRepository.allNurses(emptyNurseState, emptyNurseListState)


        var selected by remember { mutableIntStateOf(0) }
        Scaffold(

            topBar = {
                TopAppBar(
                    modifier = Modifier.padding(bottom = 40.dp),
                    colors = TopAppBarDefaults.topAppBarColors(Color.Black),
                    title = {
                        Row {

                            Image(painter = painterResource(id = R.drawable.nurseicon),
                                contentDescription = "home",
                                modifier = Modifier.size(20.dp),
                                colorFilter = ColorFilter.tint(Color.White)
                            )

                            Text(text = "Nurses",
                                modifier = Modifier
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                fontFamily = FontFamily.Serif,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )

                        }

                    }
                )

            },


            //Content Section
            content = @Composable {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Bluey),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "All Nurses",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Cursive,
                        color = Color.Red)

                    Spacer(modifier = Modifier.height(50.dp))

                    LazyColumn(){
                        items(nurses){
                            NurseItem2(
                                name = it.name,
                                id = it.id,
                                navController = navController,
                                nurseRepository = nurseRepository,
                                nurseImage = it.imageUrl
                            )
                        }
                    }
                }

            }

        )
    }
}







@Composable
fun NurseItem2(name:String, id:String,
              navController: NavController,
              nurseRepository: NurseViewModel, nurseImage:String) {

    //1 item
    Column(modifier = Modifier
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center

    ) {
        Card (modifier = Modifier
            .height(250.dp)
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp)
        ) {
            Box (modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.Center) {
                Image(
                    painter = rememberAsyncImagePainter(nurseImage),
                    contentDescription = "null",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )


                Row (modifier = Modifier.align(Alignment.BottomStart)) {
                    Column (modifier = Modifier
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color.Black
                                )
                            )
                        )
                        .fillMaxWidth()
                    ) {
                        //details

                        Text(text = "Name : $name",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily.Serif,
                            color = Color.White
                        )


                        Spacer(modifier = Modifier.height(5.dp))


                        val mContext = LocalContext.current



                        //end details

                    }
                }

            }
        }
        //end 1 item

    }
}



@Composable
@Preview(showBackground = true)
fun ViewNursesScreen2Preview(){

    ViewNursesScreen2(navController = rememberNavController())

}