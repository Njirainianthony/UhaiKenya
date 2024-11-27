package com.example.antoproject.models

class Booking {
    var name:String = ""
    var problem:String = ""
    var date:String = ""
    var phone:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, problem: String, phone: String, date: String, imageUrl: String, id: String) {
        this.name = name
        this.problem = problem
        this.date = date
        this.phone = phone
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()

}