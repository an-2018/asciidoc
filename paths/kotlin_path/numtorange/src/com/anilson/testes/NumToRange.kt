package com.anilson.testes

fun main(){
    println(numToRange(1393))
}

fun rightRange(num:Int):Int{

    val numStr = num.toString()
    val len = numStr.length
    var rightRange = 9

    if(len > 1) {
        var str = ""
        for (i in 1 until len) str += "0"
        rightRange = rightRange(numStr.substring(1 until len).toInt())
    }

    return rightRange
}

fun numToRange(num:Int):IntRange?{
    val numStr = num.toString()
    val len = numStr.length
    var leftRange = 0
    var rightRange = 9

    if(len > 1) {
        leftRange = (numStr.substring(0 until len-1) + "0").toInt()
        rightRange += leftRange
    }
    return leftRange..rightRange
}
class NumToRange {
}