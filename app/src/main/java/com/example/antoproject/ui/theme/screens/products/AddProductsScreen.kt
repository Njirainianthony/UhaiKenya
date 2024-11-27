package com.example.antoproject.ui.theme.screens.products

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.antoproject.R
import com.example.antoproject.data.ProductViewModel
import com.example.antoproject.navigation.ADD_PRODUCTS_URL
import com.example.antoproject.navigation.VIEW_PRODUCTS_URL
import com.example.antoproject.ui.theme.Bluey


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductsScreen(navController: NavController){
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
                    contentColor = Color.Black){
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
                    containerColor = Color.Black
                ) {
                    IconButton(onClick = {
                        navController.navigate(ADD_PRODUCTS_URL)
                    },
                        ) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu", tint = Color.White)
                    }
                }
            },
            //Content Section
            content = @Composable{
                Card(colors = CardDefaults.cardColors(Color.White),
                    modifier = Modifier.padding(start = 30.dp, top = 30.dp, bottom = 150.dp, end = 30.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                            .padding(30.dp)
                        ,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){

                        Image(
                            painter = painterResource(id = R.drawable.pharmacyicon),
                            contentDescription ="home",
                            modifier = Modifier
                                .size(150.dp).padding(20.dp),
                            contentScale = ContentScale.Crop,


                            )


                        Spacer(modifier = Modifier.height(15.dp))

                        Text(
                            text = "Upload Here!",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif)

                        var productName by remember { mutableStateOf("") }
                        var productQuantity by remember { mutableStateOf("") }
                        var productPrice by remember { mutableStateOf("") }
                        var phone by remember { mutableStateOf("") }
                        val context = LocalContext.current

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = productName,
                            onValueChange = { productName = it },
                            label = { Text(text = "Product name ", color = Color.Black, fontFamily = FontFamily.Serif) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = productQuantity,
                            onValueChange = { productQuantity = it },
                            label = { Text(text = "Product quantity e.g 250g ", fontFamily = FontFamily.Serif, color = Color.Black) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = productPrice,
                            onValueChange = { productPrice = it },
                            label = { Text(text = "Product price e.g Ksh.500",fontFamily = FontFamily.Serif, color = Color.Black) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        OutlinedTextField(
                            value = phone,
                            onValueChange = { phone = it },
                            label = { Text(text = "Phone",fontFamily = FontFamily.Serif, color = Color.Black) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )

                        Spacer(modifier = Modifier.height(20.dp))



                        //---------------------IMAGE PICKER START-----------------------------------//

                        var modifier = Modifier
                        ImagePicker(modifier,context, navController, productName.trim(), productQuantity.trim(), productPrice.trim(),phone.trim())

                        //---------------------IMAGE PICKER END-----------------------------------//



                    }
                }




            }

        )

    }
}



val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon= Icons.Filled.Home,
        unselectedIcon= Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Upload",
        route="addproducts",
        selectedIcon= Icons.Filled.Add,
        unselectedIcon= Icons.Outlined.Add,
        hasNews = true,
        badges=0
    ),

    BottomNavItem(
        title = "View",
        route="viewproducts",
        selectedIcon= Icons.Filled.Info,
        unselectedIcon= Icons.Outlined.Info,
        hasNews = true,
        badges=1
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
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavController, name:String, quantity:String, price:String, phone:String) {
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
                var productRepository = ProductViewModel(navController,context)
                productRepository.uploadProduct(name, quantity, price,phone,imageUri!!)



            },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)) {
                Text(text = "Upload")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun AddProductsScreenPreview(){
    AddProductsScreen(navController = rememberNavController())

}