package com.example.SmartPark.models

import androidx.compose.ui.text.input.TextFieldValue

class User {
    var name:String = ""
    var email:String = ""
    var password:String = ""
    var id:String = ""
    var phone:String = ""
    var cartype:String = ""

    constructor(name: TextFieldValue, email: TextFieldValue, password: TextFieldValue, id: String) {
        this.name = name.toString()
        this.email = email.toString()
        this.password = password.toString()
        this.id = id
        this.phone = phone
        this.cartype = cartype
    }

    constructor()
}