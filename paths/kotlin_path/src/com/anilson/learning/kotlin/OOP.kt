package com.anilson.learning.kotlin

fun main(){

}

class OOP(name:String) {
    var name:String = ""
        get() = field
        set(value) {
            field = value
        }
}