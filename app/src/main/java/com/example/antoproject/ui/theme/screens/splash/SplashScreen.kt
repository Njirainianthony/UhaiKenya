package com.example.antoproject.ui.theme.screens.splash

import android.annotation.SuppressLint
import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.antoproject.navigation.ROUT_HOME
import com.example.antoproject.navigation.ROUT_LOGIN
import com.example.antoproject.navigation.ROUT_SIGN
import com.example.antoproject.ui.theme.Bluey
import com.example.antoproject.ui.theme.Grey
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable

fun SplashScreen(navController: NavController){

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Bluey),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //COROUTINE SCOPE  - FUNCTION IS TO MOVE AUTOMATICALLY TO THE PAGE DEFINED BELOW IN THE CODE
        var coroutineScope= rememberCoroutineScope()
        coroutineScope.launch {
            delay(2000)
            navController.navigate(ROUT_LOGIN)
        }
        //End of coroutine scope

        //Lottie Animation
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.hospital))
        val progress by animateLottieCompositionAsState(composition)
        LottieAnimation(composition, progress,
            modifier = Modifier.size(300.dp)
        )

        //End of lottie animation
        Text(
            text = "Uhai Kenya",
            fontFamily = FontFamily.Serif,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold

            )



    }


}




@Composable
@Preview(showBackground = true)
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())


}