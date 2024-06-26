package com.example.SmartPark.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.example.SmartPark.models.Admin
import com.example.SmartPark.navigation.ADD_PRODUCTS_URL

import com.example.SmartPark.navigation.RENTER_URL
import com.example.SmartPark.navigation.RSIGNUP_URL

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AdminViewModel(var navController: NavController, var context: Context) {

    val mAuth: FirebaseAuth
    val progress: ProgressDialog

    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }
    fun signup(name: TextFieldValue, email: TextFieldValue, password: TextFieldValue,){
        progress.show()
        mAuth.createUserWithEmailAndPassword(email.toString(), password.toString()).addOnCompleteListener {
            var adminId = mAuth.currentUser!!.uid
            var adminProfile = Admin(name, email, password, adminId)
            // Create a reference table called Admin inside of the Firebase database
            var adminRef = FirebaseDatabase.getInstance().getReference()
                .child("Admin/$adminId")
            adminRef.setValue(adminProfile).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful){
                    Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                    navController.navigate(RENTER_URL)
                }else{
                    Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    fun login(email: String, password: String){
        progress.show()
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                navController.navigate(ADD_PRODUCTS_URL)
            }else{
                Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun logout(){
        mAuth.signOut()
        navController.navigate(RENTER_URL)
    }

    fun isLoggedIn(): Boolean = mAuth.currentUser != null

}