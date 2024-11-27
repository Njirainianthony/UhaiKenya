package com.example.antoproject.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.antoproject.models.Nurse
import com.example.antoproject.models.Ward
import com.example.antoproject.navigation.ADD_NURSES_URL
import com.example.antoproject.navigation.ADD_WARDS_URL
import com.example.antoproject.navigation.ROUT_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class WardViewModel(var navController: NavController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress: ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(ROUT_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadWard(name:String,filePath: Uri){
        val wardId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Wards/$wardId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var ward = Ward(name,imageUrl,wardId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Ward/$wardId")
                    databaseRef.setValue(ward).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allWards(
        ward: MutableState<Ward>,
        wards: SnapshotStateList<Ward>
    ): SnapshotStateList<Ward> {
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Wards")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                wards.clear()
                for (snap in snapshot.children){
                    var retrievedWard = snap.getValue(Ward::class.java)
                    ward.value = retrievedWard!!
                    wards.add(retrievedWard)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return wards
    }

    fun updateWard(wardId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Wards/$wardId")
        ref.removeValue()
        navController.navigate(ADD_WARDS_URL)
    }


    fun deleteWards(wardId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Wards/$wardId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}