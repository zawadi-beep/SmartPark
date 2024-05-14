package com.example.SmartPark.models

import androidx.compose.ui.text.input.TextFieldValue

class Admin {

        var name:String = ""
        var email:String = ""
        var password:String = ""
        var id:String = ""
        var phone:String = ""


        constructor(name: TextFieldValue, email: TextFieldValue, password: TextFieldValue, id: String) {
            this.name = name.toString()
            this.email = email.toString()
            this.password = password.toString()
            this.id = id
            this.phone = phone

        }

    constructor()



}