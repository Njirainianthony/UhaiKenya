package com.example.antoproject.ui.theme.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
import com.example.antoproject.R
import com.example.antoproject.navigation.ADD_BOOKING_URL
import com.example.antoproject.navigation.ROUT_ABOUT
import com.example.antoproject.navigation.ROUT_ADMIN
import com.example.antoproject.navigation.ROUT_GALLERY
import com.example.antoproject.navigation.ROUT_HOME
import com.example.antoproject.navigation.VIEW_DOCTORS_URL
import com.example.antoproject.navigation.VIEW_PRODUCTS2_URL
import com.example.antoproject.navigation.VIEW_PRODUCTS_URL
import com.example.antoproject.ui.theme.Bluey

@Composable

fun DashboardScreen(navController: NavController){

    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        Spacer(modifier = Modifier.height(70.dp))

        Image(
            painter = painterResource(id = R.drawable.hospitalicon),
            contentDescription ="home",
            modifier = Modifier
                .size(180.dp)
                .padding(20.dp),
            contentScale = ContentScale.Crop

        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Welcome to the dashboard",
            fontSize = 20.sp,
            fontFamily = FontFamily.Serif,
            color = Color.Black,
            fontWeight = FontWeight.ExtraBold

        )

        Spacer(modifier = Modifier.height(20.dp))



        Column (modifier = Modifier.verticalScroll(rememberScrollState())){

            //START OF MAIN CARD
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(700.dp)
                    .padding(top = 30.dp)
                    .verticalScroll(rememberScrollState()),
                shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp),
                colors = CardDefaults.cardColors(Bluey)

            ){

                Spacer(modifier = Modifier.height(30.dp))

                //ROW 1

                Row (modifier = Modifier.padding(20.dp)){
                    //CARD 1
                    Card (modifier = Modifier
                        .width(170.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_HOME) },
                        elevation = CardDefaults.cardElevation(30.dp)
                    ){

                        Column() {

                            Spacer(modifier = Modifier.height(20.dp))


                            Box (modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ){
                                Image(painter = painterResource(id = R.drawable.homeicon),
                                    contentDescription = "home",
                                    modifier = Modifier.size(70.dp)
                                )

                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Home",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )

                        }


                    }
                    //END OF CARD 1

                    Spacer(modifier = Modifier.width(30.dp))

                    //CARD 2
                    Card (modifier = Modifier
                        .width(170.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_ABOUT) },
                        elevation = CardDefaults.cardElevation(30.dp)
                    ){

                        Column() {

                            Spacer(modifier = Modifier.height(20.dp))


                            Box (modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ){

                                Image(painter = painterResource(id = R.drawable.abouticon),
                                    contentDescription = "home",
                                    modifier = Modifier.size(70.dp)
                                )


                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "About Us",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )

                        }


                    }
                    //END OF CARD 2


                }
                //END OF ROW 1



                //ROW 2

                Row (modifier = Modifier.padding(20.dp)){
                    //CARD 1
                    Card (modifier = Modifier
                        .width(170.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ADD_BOOKING_URL) },
                        elevation = CardDefaults.cardElevation(30.dp)
                    ){

                        Column() {

                            Spacer(modifier = Modifier.height(20.dp))


                            Box (modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ){
                                Image(painter = painterResource(id = R.drawable.bookingicon),
                                    contentDescription = "home",
                                    modifier = Modifier.size(70.dp)
                                )

                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Book Appointment",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )

                        }


                    }
                    //END OF CARD 1

                    Spacer(modifier = Modifier.width(30.dp))

                    //CARD 2
                    Card (modifier = Modifier
                        .width(170.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(VIEW_PRODUCTS2_URL) },
                        elevation = CardDefaults.cardElevation(30.dp)
                    ){

                        Column() {

                            Spacer(modifier = Modifier.height(20.dp))


                            Box (modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ){
                                Image(painter = painterResource(id = R.drawable.pharmacyicon),
                                    contentDescription = "home",
                                    modifier = Modifier.size(70.dp)
                                )

                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Pharmacy",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )

                        }


                    }
                    //END OF CARD 2


                }
                //END OF ROW 2


                //ROW 3

                Row (modifier = Modifier.padding(20.dp)){
                    //CARD 1
                    Card (modifier = Modifier
                        .width(170.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_ADMIN) },
                        elevation = CardDefaults.cardElevation(30.dp)
                    ){

                        Column() {

                            Spacer(modifier = Modifier.height(20.dp))


                            Box (modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ){
                                Image(painter = painterResource(id = R.drawable.adminicon),
                                    contentDescription = "home",
                                    modifier = Modifier.size(70.dp)
                                )

                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Admin Section",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )

                        }


                    }
                    //END OF CARD 1

                    Spacer(modifier = Modifier.width(30.dp))

                    //CARD 2
                    Card (modifier = Modifier
                        .width(170.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_GALLERY) },
                        elevation = CardDefaults.cardElevation(30.dp)
                    ){

                        Column() {

                            Spacer(modifier = Modifier.height(20.dp))


                            Box (modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ){
                                Image(painter = painterResource(id = R.drawable.galleryicon),
                                    contentDescription = "home",
                                    modifier = Modifier.size(70.dp)
                                )

                            }

                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Gallery Section",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )

                        }


                    }
                    //END OF CARD 2


                }
                //END OF ROW 3





            }

            //END OF MAIN CARD
        }





    }

}




@Composable
@Preview(showBackground = true)
fun DashboardScreenPreview(){
    DashboardScreen(rememberNavController())


}