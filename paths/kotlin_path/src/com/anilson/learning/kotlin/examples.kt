package com.anilson.learning.kotlin

import java.io.IOException
import java.lang.NumberFormatException


fun main(args:Array<String>){

   val examples: Examples = Examples();
    examples.extensions("word")
}

class Examples {

    fun checkString(s:String): Boolean{

        if(s.isEmpty() || s[0] in '0'..'9') return false

        fun isValid(c:Char) = c == '_' || c in 'a'..'z' || c in 'A'..'Z' || c in '0'..'9'

        for(c in s){
            if(!isValid(c)) return false
        }

        return true
    }
   // loops
   fun loop(){

      println("== Loops ==")
      val map = mapOf(
                     1 to "a",
                     2 to "b",
                     3 to "c")

      for((key, value) in map){
         print("Value $key is $value")
      }
       // ranges upper bound included
       for (i in 1..10){
           print(i)
       }

       // ranges upper bound excluded
       for(i in 1 until 10){
           print(i)
       }

       for(i in 9 downTo 1){
           print(i)
       }

       for(ch in "abc"){
           println(ch +1)
       }

       for(c in '0'..'9'){
           print(c)
       }

       // in range check => a.compareTo(b) and list.contains(variable)
       // comparable interface
       print("\n ${"ball".compareTo("ball")}")
       val res = 'a'..'z'
       for(r in res){
           print("kkk".length)
       }
   }

    // exceptions
    // no checked and unchecked exceptions
    @Throws(IOException::class) // if used with java
    fun exceptions() {
        val s:String = "90"
        val number = try {
            Integer.parseInt(s)
        } catch (e: NumberFormatException) {
            null
        }
    }

    // static method in java - cant override original methods
    fun extensions(word:String){
        fun String.lastChar() = get(length -1)

        val regex = """\d{2}""".toRegex()
        regex.matches("12.112")

        print(word.lastChar())

        "123".toIntOrNull()

        // until is and infix extension function
    }
}