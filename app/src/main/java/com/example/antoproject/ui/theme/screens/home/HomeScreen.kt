package com.example.antoproject.ui.theme.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

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
import com.example.antoproject.navigation.ROUT_ABOUT
import com.example.antoproject.navigation.ROUT_DASHBOARD
import com.example.antoproject.ui.theme.Blue
import com.example.antoproject.ui.theme.Bluey
import com.example.antoproject.ui.theme.Lavender
import com.example.antoproject.ui.theme.Lightblue


@Composable
fun HomeScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Bluey),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

        ) {

        //Lottie Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.hospital))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(composition, progress,
            modifier = Modifier.size(300.dp)
        )

        //End of lottie animation

        Text(
            text = "Welcome to Uhai Kenya",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            color = Color.Black,
            fontWeight = FontWeight.Bold

            )


        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text ="Saving lives",
            fontSize = 25.sp,
            fontFamily = FontFamily.Serif

        )

        Spacer(modifier = Modifier.height(200.dp))

        Button(
            onClick = { navController.navigate(ROUT_DASHBOARD) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(10.dp)
        ) {

            Text(text = "Go To Dashboard",
                color = Color.White,
                fontWeight = FontWeight.Bold
                )
            
        }

    }


}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}


