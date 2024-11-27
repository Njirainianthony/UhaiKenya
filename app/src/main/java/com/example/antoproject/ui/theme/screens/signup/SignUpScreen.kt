package com.example.antoproject.ui.theme.screens.signup

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.antoproject.R
import com.example.antoproject.data.AuthViewModel
import com.example.antoproject.navigation.ROUT_HOME
import com.example.antoproject.navigation.ROUT_LOGIN
import com.example.antoproject.ui.theme.Blue
import com.example.antoproject.ui.theme.Bluey
import com.example.antoproject.ui.theme.Lightblue

@Composable

fun SignUpScreen(navController: NavController){
    


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, bottom = 30.dp)
            .verticalScroll(rememberScrollState())
            .background(Bluey),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

        ) {

        Spacer(modifier = Modifier.height(40.dp))


        Image(
            painter = painterResource(id = R.drawable.hospitalicon),
            contentDescription ="hospital",
            modifier = Modifier
                .size(180.dp),
            contentScale = ContentScale.Crop,


        )

        Spacer(modifier = Modifier.height(30.dp))

       Card (modifier = Modifier.padding(start = 30.dp, top = 30.dp, bottom = 40.dp, end = 30.dp),
           shape = RoundedCornerShape(30.dp),
           colors = CardDefaults.cardColors(White),


       ){


           Spacer(modifier = Modifier.height(10.dp))


           Text(
               text = "Sign Up",
               fontSize = 30.sp,
               fontFamily = FontFamily.Serif,
               color = Color.Black,
               fontWeight = FontWeight.Bold,
               modifier = Modifier.padding(start = 120.dp)
           )

           var name by remember { mutableStateOf("") }
           var email by remember { mutableStateOf("") }
           var password by remember { mutableStateOf("") }
           var confpassword by remember { mutableStateOf("") }
           var passwordVisible by remember { mutableStateOf(false) }
           // Function to determine visual transformation based on visibility
           val visualTransformation: VisualTransformation =
               if (passwordVisible) VisualTransformation.None
               else PasswordVisualTransformation()
           // Function to switch the password visibility
           fun togglePasswordVisibility() {
               passwordVisible = !passwordVisible
           }



           Spacer(modifier = Modifier.height(30.dp))


           OutlinedTextField(

               value = name,
               onValueChange ={name=it},
               label = { Text(
                   text = "Full Name",
                   color = Black
               )},
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(start = 20.dp, end = 20.dp),
               shape = RoundedCornerShape(10.dp),
               leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "person", tint = Black)},
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),

               )

           Spacer(modifier = Modifier.height(20.dp))

           OutlinedTextField(

               value = email,
               onValueChange ={email=it},
               label = { Text(
                   text = "Email Address",
                   color = Black
               )},
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(start = 20.dp, end = 20.dp),
               shape = RoundedCornerShape(10.dp),
               leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "email", tint = Black)},
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

               )

           Spacer(modifier = Modifier.height(20.dp))

           OutlinedTextField(

               value = password,
               onValueChange ={password=it},
               label = { Text(
                   text = "Enter password",
                   color = Color.Black
               )},
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(start = 20.dp, end = 20.dp),
               shape = RoundedCornerShape(10.dp),
               leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "password", tint = Black)},
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
               visualTransformation = visualTransformation,
               trailingIcon = {
                   val icon = if (passwordVisible) {
                       //Download a password show icon
                       painterResource(id = R.drawable.passwordshow,)
                   } else {
                       //Download a password hide icon
                       painterResource(id = R.drawable.passwordhide)
                   }
                   IconButton(onClick = { togglePasswordVisibility() }, modifier = Modifier.size(20.dp)) {
                       Icon(painter = icon, contentDescription = null)
                   }
               }

           )

           Spacer(modifier = Modifier.height(20.dp))

           OutlinedTextField(

               value = confpassword,
               onValueChange ={confpassword=it},
               label = { Text(text = "Confirm Password",
                   color = Color.Black
               )},
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(start = 20.dp, end = 20.dp),
               shape = RoundedCornerShape(10.dp),
               leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "password", tint = Black)},
               keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
               visualTransformation = visualTransformation,
               trailingIcon = {
                   val icon = if (passwordVisible) {
                       //Download a password show icon
                       painterResource(id = R.drawable.passwordshow,)
                   } else {
                       //Download a password hide icon
                       painterResource(id = R.drawable.passwordhide)
                   }
                   IconButton(onClick = { togglePasswordVisibility() }, modifier = Modifier.size(20.dp)) {
                       Icon(painter = icon, contentDescription = null)
                   }
               }


           )

           Spacer(modifier = Modifier.height(30.dp))




           val context = LocalContext.current
           val authViewModel = AuthViewModel(navController, context)

           Button(
               onClick = {

                   authViewModel.signup(name, email, password,confpassword)

               },
               modifier = Modifier
                   .fillMaxWidth()
                   .height(50.dp)
                   .padding(start = 20.dp, end = 20.dp),
               colors = ButtonDefaults.buttonColors(Black),
               shape = RoundedCornerShape(10.dp)
           ) {

               Text(text = "Create Account",
                   color = Color.White,
                   fontWeight = FontWeight.Bold)

           }

           Spacer(modifier = Modifier.height(30.dp))

           Button(
               onClick = {navController.navigate(ROUT_LOGIN) },
               modifier = Modifier
                   .fillMaxWidth()
                   .height(50.dp)
                   .padding(start = 20.dp, end = 20.dp),
               colors = ButtonDefaults.buttonColors(Black),
               shape = RoundedCornerShape(10.dp)
           ) {

               Text(text = "Login",
                   color = Color.White)

           }

           Spacer(modifier = Modifier.height(20.dp))
       }






    }

}




@Composable
@Preview(showBackground = true)
fun SignUpScreenPreview(){
    SignUpScreen(rememberNavController())
}
