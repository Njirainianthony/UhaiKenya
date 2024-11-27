package com.example.antoproject.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.antoproject.models.User
import com.example.antoproject.navigation.ROUT_ADMIN
import com.example.antoproject.navigation.ROUT_DASHADMIN
import com.example.antoproject.navigation.ROUT_HOME
import com.example.antoproject.navigation.ROUT_LOGIN
import com.example.antoproject.navigation.ROUT_SIGN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(var navController: NavController, var context: Context){
    val mAuth: FirebaseAuth
    val progress: ProgressDialog

    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }
    fun signup(name:String, email:String, password:String,confpassword:String){
        progress.show()

        if (email.isBlank() || password.isBlank() ||confpassword.isBlank()){
            progress.dismiss()
            Toast.makeText(context,"Please email and password cannot be blank", Toast.LENGTH_LONG).show()
        }else if (password != confpassword){
            Toast.makeText(context,"Password do not match", Toast.LENGTH_LONG).show()
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                if (it.isSuccessful){
                    val userdata= User(name,email,password,mAuth.currentUser!!.uid)
                    val regRef=FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {

                        if (it.isSuccessful){
                            Toast.makeText(context,"Registered Successfully", Toast.LENGTH_LONG).show()
                            navController.navigate(ROUT_LOGIN)

                        }else{
                            Toast.makeText(context,"${it.exception!!.message}", Toast.LENGTH_LONG).show()
                            navController.navigate(ROUT_SIGN)
                        }
                    }
                }else{
                    navController.navigate(ROUT_SIGN)
                }

            } }

    }

    fun login(email: String, password: String){
        progress.show()

        if (email.isBlank() || password.isBlank()){
            Toast.makeText(context,"Please email and password cannot be blank", Toast.LENGTH_LONG).show()
        }else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful){
                    Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUT_HOME)
                }else{
                    Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    fun adminlogin(email: String, password: String){
        progress.show()

        if (email.isBlank() || password.isBlank()){
            Toast.makeText(context,"Please email and password cannot be blank", Toast.LENGTH_LONG).show()
        }
        else if(email=="anthonynjiraini@gamil.com"&&password=="Anthonynjoroge04*"){
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful){
                    Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUT_DASHADMIN)
                }else{
                    Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                }
            }

        }

        else{
            navController.navigate(ROUT_ADMIN)
        }
    }

    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUT_LOGIN)
    }

    fun isLoggedIn(): Boolean = mAuth.currentUser != null

}