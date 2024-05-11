package com.example.SmartPark.models

class User {
    var name:String = ""
    var email:String = ""
    var password:String = ""
    var id:String = ""
    var phone:String = ""
    var cartype:String = ""

    constructor(name: String, email: String, password: String, id: String) {
        this.name = name
        this.email = email
        this.password = password
        this.id = id
        this.phone = phone
        this.cartype = cartype
    }

    constructor()
}