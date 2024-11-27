package com.example.antoproject.ui.theme.screens.bookings

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.antoproject.R
import com.example.antoproject.data.BookingViewModel
import com.example.antoproject.data.ProductViewModel
import com.example.antoproject.navigation.ADD_BOOKING_URL
import com.example.antoproject.navigation.ADD_PRODUCTS_URL
import com.example.antoproject.ui.theme.Bluey
import java.util.Calendar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBookingScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Bluey)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            containerColor = Bluey,
            bottomBar = {
                NavigationBar (
                    containerColor = Color.Black,
                    contentColor = Color.White){
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
                                            Badge (containerColor = Color.White){
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
                                        contentDescription = bottomNavItem.title, tint = Color.White)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title,
                                    color = Color.White)
                            }
                        )
                    }
                }
            },

            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    containerColor = Color.Black,
                    contentColor = Color.White
                ) {
                    IconButton(onClick = {
                        navController.navigate(ADD_BOOKING_URL)
                    },
                    ) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu", tint = Color.White)
                    }
                }
            },
            //Content Section
            content = @Composable {
                Card(colors = CardDefaults.cardColors(Color.White),
                    modifier = Modifier.padding(start = 10.dp, top = 30.dp, bottom = 150.dp, end = 10.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(10.dp)
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){

                        Image(
                            painter = painterResource(id = R.drawable.bookingicon),
                            contentDescription ="home",
                            modifier = Modifier
                                .size(120.dp),
                            contentScale = ContentScale.Crop,


                            )


                        Spacer(modifier = Modifier.height(20.dp))

                        Text(
                            text = "Book An Appointment",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif)

                        var bookingName by remember { mutableStateOf("") }
                        var bookingProblem by remember { mutableStateOf("") }
                        var bookingDate by remember { mutableStateOf("") }
                        var phone by remember { mutableStateOf("") }
                        val context = LocalContext.current

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            modifier = Modifier.width(310.dp),
                            value = bookingName,
                            onValueChange = { bookingName = it },
                            label = { Text(text = "Enter your name", color = Color.Black, fontFamily = FontFamily.Serif) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            modifier = Modifier.width(310.dp),
                            value = bookingProblem,
                            onValueChange = { bookingProblem = it },
                            label = { Text(text = "Describe your problem", fontFamily = FontFamily.Serif, color = Color.Black) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        //DateField
                        var selectedDate by remember { mutableStateOf<String?>(null) }
                        var showDatePicker by remember { mutableStateOf(false) }



                        Row(modifier = Modifier.padding(start = 20.dp, end = 20.dp)){

                            Button(onClick = {
                                val calendar = Calendar.getInstance()
                                val year = calendar.get(Calendar.YEAR)
                                val month = calendar.get(Calendar.MONTH)
                                val day = calendar.get(Calendar.DAY_OF_MONTH)

                                DatePickerDialog(
                                    //Don't forget to create the context variable located just below
                                    //the aboutscreen function
                                    context,
                                    { _, selectedYear, selectedMonth, selectedDay ->
                                        selectedDate = "${selectedDay}/${selectedMonth + 1}/${selectedYear}"
                                    },
                                    year,
                                    month,
                                    day
                                ).show()
                            },
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(Color.Gray),
                                modifier = Modifier
                                    .height(65.dp)
                                    .padding(top = 15.dp, end = 10.dp)) {
                                Text(text = "Select Date")
                            }
                            Spacer(modifier = Modifier.width(10.dp))

                            OutlinedTextField(
                                value = selectedDate ?: "",
                                onValueChange = { /* No-op, as we handle value through date picker */ },
                                label = { Text("Select Date") },
                                readOnly = true,  // Makes the text field non-editable
                                modifier = Modifier
                                    .padding(bottom = 16.dp, top = 10.dp)
                                    .width(250.dp).height(55.dp),
                                trailingIcon = {
                                    Text(text = "📅")  // Icon to indicate date picker
                                },
                                singleLine = true
                            )


                        }

                        //End of a datefield

                        Spacer(modifier = Modifier.height(20.dp))

                        OutlinedTextField(
                            modifier = Modifier.width(310.dp),
                            value = phone,
                            onValueChange = { phone = it },
                            label = { Text(text = "Phone number",fontFamily = FontFamily.Serif, color = Color.Black) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )

                        Spacer(modifier = Modifier.height(20.dp))



                        //---------------------IMAGE PICKER START-----------------------------------//

                        var modifier = Modifier
                        ImagePicker(modifier,context, navController, bookingName.trim(), bookingProblem.trim(), phone.trim(), selectedDate.toString().trim())

                        //---------------------IMAGE PICKER END-----------------------------------//



                    }
                }




            }

        )

    }
}



val bottomNavItems = listOf(
    BottomNavItem(
        title = "Dashboard",
        route="dashboard",
        selectedIcon= Icons.Filled.Menu,
        unselectedIcon= Icons.Outlined.Menu,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Add",
        route="addbooking",
        selectedIcon= Icons.Filled.Add,
        unselectedIcon= Icons.Outlined.Add,
        hasNews = true,
        badges=0
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


@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavController, name:String, problem:String, date:String, phone:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.
            getBitmap(context.contentResolver,imageUri)
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Image(bitmap = bitmap.asImageBitmap(),
                    contentDescription = "Selected image",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(
                    text = "Select Image"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var bookingRepository = BookingViewModel(navController,context)
                bookingRepository.uploadBooking(name, problem, date, phone, imageUri!!)



            },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)) {
                Text(text = "Book", fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AddBookingsScreenPreview(){
    AddBookingScreen(navController = rememberNavController())

}