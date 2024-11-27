package com.example.antoproject.models

class Doctor{
    var name:String = ""
    var phone:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, phone: String, imageUrl: String, id: String) {
        this.name = name
        this.phone = phone
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}