package com.example.SmartPark.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.SmartPark.models.Space
import com.example.SmartPark.navigation.RENTER_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class SpaceViewModel(var navController:NavHostController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(RENTER_URL)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadSpace(name:String, quantity:String, price:String, filePath:Uri){
        val spaceId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Spaces/$spaceId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var Space= Space(name,quantity,price,imageUrl,spaceId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Spaces/$spaceId")
                    databaseRef.setValue(Space).addOnCompleteListener {
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

    fun allSpaces(
        space:MutableState<Space>,
        spaces:SnapshotStateList<Space>):SnapshotStateList<Space>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Space")
        ref.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                spaces.clear()
                for (snap in snapshot.children){
                    var retrievedSpace = snap.getValue(Space::class.java)
                    space.value = retrievedSpace!!
                    spaces.add(retrievedSpace)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return spaces
    }

    fun deleteSpace(spaceId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Spaces/$spaceId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}
