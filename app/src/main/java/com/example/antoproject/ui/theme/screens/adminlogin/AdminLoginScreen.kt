package com.example.antoproject.ui.theme.screens.adminlogin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.antoproject.R
import com.example.antoproject.data.AuthViewModel
import com.example.antoproject.navigation.ROUT_DASHADMIN
import com.example.antoproject.navigation.ROUT_HOME
import com.example.antoproject.navigation.ROUT_SIGN
import com.example.antoproject.ui.theme.Bluey

@Composable

fun AdminLoginScreen(navController: NavController){

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 30.dp, bottom = 30.dp)
        .background(Bluey),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(100.dp))

        Image(
            painter = painterResource(id = R.drawable.adminicon),
            contentDescription ="home",
            modifier = Modifier
                .size(150.dp),
            contentScale = ContentScale.Crop,


            )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Login Admin",
            fontSize = 30.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.Black,
            fontWeight = FontWeight.Bold

        )
        Spacer(modifier = Modifier.height(10.dp))

        Spacer(modifier = Modifier.height(20.dp))

        Card(modifier = Modifier.padding(20.dp),
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp, bottomStart = 30.dp, bottomEnd = 30.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {

            Spacer(modifier = Modifier.height(10.dp))


            Text(
                text = "Login for admin only",
                fontSize = 15.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                textAlign = TextAlign.Center

            )




            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var passwordVisible by remember { mutableStateOf(false) }

            val visualTransformation: VisualTransformation =
                if (passwordVisible) VisualTransformation.None
                else PasswordVisualTransformation()
            // Function to switch the password visibility
            fun togglePasswordVisibility() {
                passwordVisible = !passwordVisible
            }



            Spacer(modifier = Modifier.height(30.dp))


            OutlinedTextField(

                value = email,
                onValueChange ={email=it},
                label = { Text(
                    text = "Email Address",
                    color = Color.Black

                )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email", tint = Color.Black) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

                )

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(

                value = password,
                onValueChange ={password=it},
                label = { Text(text = "Enter password",
                    color = Color.Black
                )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "password", tint = Color.Black) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = visualTransformation,
                trailingIcon = {
                    val icon = if (passwordVisible) {
                        //Download a password show icon
                        painterResource(id = R.drawable.passwordshow)
                    } else {
                        //Download a password hide icon
                        painterResource(id = R.drawable.passwordhide)
                    }
                    IconButton(onClick = { togglePasswordVisibility() },modifier = Modifier.size(20.dp)) {
                        Icon(painter = icon, contentDescription = null)
                    }
                }

            )

            Spacer(modifier = Modifier.height(30.dp))


            val context = LocalContext.current
            val authViewModel = AuthViewModel(navController, context)

            Button(
                onClick = {
                    authViewModel.adminlogin(email, password)
                    navController.navigate(ROUT_DASHADMIN) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 20.dp, end = 20.dp),
                colors = ButtonDefaults.buttonColors(Color.Black),
                shape = RoundedCornerShape(10.dp)
            ) {

                Text(text = "Login",
                    color = Color.White,
                    fontWeight = FontWeight.Bold)

            }

            Spacer(modifier = Modifier.height(15.dp))



            Spacer(modifier = Modifier.height(20.dp))
        }



    }

}




@Composable
@Preview(showBackground = true)
fun AdminLoginScreenPreview(){
    AdminLoginScreen(rememberNavController())


}