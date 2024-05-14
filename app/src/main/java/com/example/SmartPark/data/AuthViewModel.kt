package com.example.SmartPark.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import com.example.SmartPark.models.User
import com.example.SmartPark.navigation.DASHBOARD_URL
import com.example.SmartPark.navigation.LOGIN_URL
import com.example.SmartPark.navigation.SIGNUP_URL

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(var navController: NavController, var context:Context) {
    val mAuth:FirebaseAuth
    val progress:ProgressDialog

    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }
    fun signup(name: TextFieldValue, email: TextFieldValue, password: TextFieldValue,){
        progress.show()
        mAuth.createUserWithEmailAndPassword(email.toString(), password.toString()).addOnCompleteListener {
            var userId = mAuth.currentUser!!.uid
            var userProfile = User(name, email, password, userId)
            // Create a reference table called Users inside of the Firebase database
            var usersRef = FirebaseDatabase.getInstance().getReference()
                .child("Users/$userId")
            usersRef.setValue(userProfile).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful){
                    Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                    navController.navigate(LOGIN_URL)
                }else{
                    Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                    navController.navigate(SIGNUP_URL)
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
                navController.navigate(DASHBOARD_URL)
            }else{
                Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                navController.navigate(LOGIN_URL)
            }
        }
    }

    fun logout(){
        mAuth.signOut()
        navController.navigate(LOGIN_URL)
    }

    fun isLoggedIn(): Boolean = mAuth.currentUser != null
}