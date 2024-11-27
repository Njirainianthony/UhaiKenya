package com.example.antoproject.ui.theme.screens.about

import android.content.Intent
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.antoproject.R
import com.example.antoproject.ui.theme.Bluey


@Composable
fun AboutScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, bottom = 45.dp)
            .background(Bluey)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){

        Image(painter = painterResource(id = R.drawable.hospitalicon),
            contentDescription ="hospital",
            modifier = Modifier
                .size(150.dp)
                .padding(20.dp),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "HISTORY",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(start = 160.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "UhaiKenya was found in 2023 by 2 qualified doctors, Dr.Jones and Dr.Alex",
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "They are two well respected doctors in the health industry who decided to form their own hospital in the outskirts of Nairobi city",
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center


        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)) {
            Image(
                painter = painterResource(id = R.drawable.foundingdoctors),
                contentDescription = "foundingdocs",
                modifier = Modifier.size(500.dp)
                )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "LOCATION",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(start = 160.dp)
            )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "We are located at Kipro Center, Westlands, 2nd floor",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold
            )

        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier
            .fillMaxWidth()
            .height(400.dp)){

            val mUrl = "https://www.google.com/maps/@-1.2610626,36.7962211,14z?entry=ttu&g_ep=EgoyMDI0MDgyMC4xIKXMDSoASAFQAw%3D%3D"

            AndroidView(factory = {
                WebView(it).apply {
                    settings.apply {
                        javaScriptEnabled=true
                    }


                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    loadUrl(mUrl)
                }

            }, update = { it.loadUrl(mUrl) })



        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "MORE INFO",
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(start = 160.dp)
        )





        Text(
            text = "If you have more inquiries, click on one of the options below to contact us",
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row (modifier = Modifier
            .fillMaxWidth()
        ){

            val mContext= LocalContext.current

            Button(
                onClick = {
                    val callIntent= Intent(Intent.ACTION_DIAL)
                    callIntent.data="tel:0706572440".toUri()
                    mContext.startActivity(callIntent)
                },
                modifier = Modifier.width(130.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "Call")
                
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("njirainianthony@gmail.com"))
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, this is the email body")
                    mContext.startActivity(shareIntent)
                },
                modifier = Modifier.width(130.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "Email")
            }

            Spacer(modifier = Modifier.width(12.dp))

            Button(
                onClick = {
                    val smsIntent= Intent(Intent.ACTION_SENDTO)
                    smsIntent.data="smsto:0706572440".toUri()
                    smsIntent.putExtra("sms_body","Hello Anthony,how can we help?")
                    mContext.startActivity(smsIntent)
                },
                modifier = Modifier.width(130.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(text = "Message")
                
            }

        }















    }



}


@Composable
@Preview(showBackground = true)
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())
}