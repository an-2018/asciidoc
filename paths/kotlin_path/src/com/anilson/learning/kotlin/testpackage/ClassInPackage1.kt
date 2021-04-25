package com.anilson.learning.kotlin.testpackage

import com.anilson.learning.kotlin.testpackge2.package2
import kotlin.random.Random

interface Factory<T>{
    fun create():T
}

class MyClass {

    val name:String = "Hello"
    companion object : Factory<MyClass> {
        override fun create() : MyClass = MyClass()
    }
}

val f: Factory<MyClass> = MyClass

class Hello {
    fun sayHello() {
        println("hello")
    }

    companion object {
        var num = 0
        fun create(): Hello {
            return Hello()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            val hi = create()
            hi.sayHello()
        }
    }
}

sealed class Seal
class DataClass{
    var hope = Enums.HOPE
}

class SubData(name:String) : Seal(){}
class Sub2 : Seal(){}
enum class Enums{
    HOPE,JANE
}

// lambdas
val x = ({println("lambdas")})()

// fields / properties

enum class State{ON, OFF}

public class StateLogger{
    private var boolState = false

    var state: State
        get() = if (boolState) State.OFF else State.OFF
        set(value:State) {
            boolState = value == State.ON
        }
}

// Mutable vs Read Only Properties

val foo: Int
    get() = Random.nextInt()

fun main() {
    println(foo)
}
val xInt = Random
