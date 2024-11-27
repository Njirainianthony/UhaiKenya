package com.example.antoproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.antoproject.ui.theme.screens.about.AboutScreen
import com.example.antoproject.ui.theme.screens.adminlogin.AdminLoginScreen
import com.example.antoproject.ui.theme.screens.bookings.AddBookingScreen
import com.example.antoproject.ui.theme.screens.bookings.ViewBookingScreen
import com.example.antoproject.ui.theme.screens.dashboard.DashboardScreen
import com.example.antoproject.ui.theme.screens.dashboardadmin.DashboardAdminScreen
import com.example.antoproject.ui.theme.screens.doctors.AddDoctorsScreen
import com.example.antoproject.ui.theme.screens.doctors.ViewDoctorScreen
import com.example.antoproject.ui.theme.screens.doctors.ViewDoctorScreen2
import com.example.antoproject.ui.theme.screens.gallery.GalleryScreen

import com.example.antoproject.ui.theme.screens.home.HomeScreen
import com.example.antoproject.ui.theme.screens.login.LoginScreen
import com.example.antoproject.ui.theme.screens.nurses.AddNursesScreen
import com.example.antoproject.ui.theme.screens.nurses.ViewNursesScreen
import com.example.antoproject.ui.theme.screens.nurses.ViewNursesScreen2
import com.example.antoproject.ui.theme.screens.products.AddProductsScreen
import com.example.antoproject.ui.theme.screens.products.ViewProducts2Screen
import com.example.antoproject.ui.theme.screens.signup.SignUpScreen
import com.example.antoproject.ui.theme.screens.splash.SplashScreen
import com.example.antoproject.ui.theme.screens.wards.AddWardsScreen
import com.example.antoproject.ui.theme.screens.wards.ViewWardsScreen
import com.example.antoproject.ui.theme.screens.wards.ViewWardsScreen2
import com.example.propertyplus.ui.theme.screens.products.ViewProductsScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination:String = ROUT_SPLASH
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {

        composable(ROUT_HOME) {
            HomeScreen(navController = navController)
        }

        composable(ROUT_ABOUT) {
            AboutScreen(navController = navController)
        }

        composable(ROUT_SPLASH) {
            SplashScreen(navController = navController)
        }

        composable(ROUT_SIGN) {
            SignUpScreen(navController = navController)
        }

        composable(ROUT_LOGIN) {
            LoginScreen(navController = navController)
        }

        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController = navController)
        }

        composable(ROUT_GALLERY) {
            GalleryScreen(navController = navController)
        }

        composable(ROUT_ADMIN) {
            AdminLoginScreen(navController = navController)
        }

        composable(ROUT_DASHADMIN) {
            DashboardAdminScreen(navController = navController)
        }

        composable(ADD_PRODUCTS_URL) {
            AddProductsScreen(navController = navController)
        }

        composable(VIEW_PRODUCTS_URL) {
            ViewProductsScreen(navController = navController)
        }

        composable(VIEW_PRODUCTS2_URL) {
            ViewProducts2Screen(navController = navController)
        }

        composable(ADD_DOCTORS_URL) {
            AddDoctorsScreen(navController = navController)
        }

        composable(VIEW_DOCTORS_URL) {
            ViewDoctorScreen(navController = navController)
        }

        composable(VIEW_DOCTORS2_URL) {
            ViewDoctorScreen2(navController = navController)
        }

        composable(ADD_NURSES_URL) {
            AddNursesScreen(navController = navController)
        }

        composable(VIEW_NURSES_URL) {
            ViewNursesScreen(navController = navController)
        }

        composable(VIEW_NURSES2_URL) {
            ViewNursesScreen2(navController = navController)
        }

        composable(ADD_WARDS_URL) {
            AddWardsScreen(navController = navController)
        }

        composable(VIEW_WARDS_URL) {
            ViewWardsScreen(navController = navController)
        }

        composable(VIEW_WARDS2_URL) {
            ViewWardsScreen2(navController = navController)
        }

        composable(ADD_BOOKING_URL) {
            AddBookingScreen(navController = navController)
        }

        composable(VIEW_BOOKING_URL) {
            ViewBookingScreen(navController = navController)
        }


    }
}