package com.example.antoproject.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.antoproject.models.Nurse
import com.example.antoproject.navigation.ADD_NURSES_URL
import com.example.antoproject.navigation.ROUT_LOGIN
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class NurseViewModel(var navController: NavController, var context: Context) {
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

    fun uploadNurse(name:String,filePath: Uri){
        val nurseId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Nurses/$nurseId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var nurse = Nurse(name,imageUrl,nurseId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Nurses/$nurseId")
                    databaseRef.setValue(nurse).addOnCompleteListener {
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

    fun allNurses(
        nurse: MutableState<Nurse>,
        nurses: SnapshotStateList<Nurse>
    ): SnapshotStateList<Nurse> {
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Nurses")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                nurses.clear()
                for (snap in snapshot.children){
                    var retrievedNurse = snap.getValue(Nurse::class.java)
                    nurse.value = retrievedNurse!!
                    nurses.add(retrievedNurse)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return nurses
    }

    fun updateNurse(nurseId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Nurses/$nurseId")
        ref.removeValue()
        navController.navigate(ADD_NURSES_URL)
    }


    fun deleteNurses(nurseId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Nurses/$nurseId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}