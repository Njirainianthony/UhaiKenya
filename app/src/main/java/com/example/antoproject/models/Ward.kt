package com.example.antoproject.models

class Ward{
    var name:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, imageUrl: String, id: String) {
        this.name = name
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}