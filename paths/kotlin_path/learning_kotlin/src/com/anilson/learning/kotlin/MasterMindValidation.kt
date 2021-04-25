package com.anilson.learning.kotlin

fun main(args:Array<String>){

    val validator = MasterMindValidation()
    print(validator.validate("abc", "sjah"))
}

class MasterMindValidation {

    private var countTotalLetter:Int = 0

    fun validate(original:String, guess:String):String {

        for(letter in guess){
            if(isValid(letter, original)) countTotalLetter++
        }

        return "Valid assertions $countTotalLetter"
    }

    private fun isValid(letter:Char, word:String):Boolean {

        for(c in word){
            if(letter == c) return true
        }

        return false
    }
}