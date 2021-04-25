package rationals

import java.math.BigInteger

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3

    val sum: Rational = half + third
    println(5 divBy 6 == sum)

    val difference: Rational = half - third
    println(1 divBy 6 == difference)

    val product: Rational = half * third
    println(1 divBy 6 == product)

    val quotient: Rational = half / third
    println(3 divBy 2 == quotient)

    val negation: Rational = -half
    println(-1 divBy 2 == negation)

    println((2 divBy 1).toString() == "2")
    println((-2 divBy 4).toString() == "-1/2")
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)
}

infix fun Int.divBy(operand:Int) = Rational(this.toBigInteger(),operand.toBigInteger())
class Rational(val n:BigInteger, val d:BigInteger){
    init {
        if(d == BigInteger.ZERO){
            throw IllegalArgumentException()
        }
    }

    infix operator fun plus(operand:Rational): Rational =
        if(operand.d == this.d) Rational(operand.n+this.n, this.d)
        else Rational((this.n * operand.d) + operand.n * this.d, operand.d * this.d)

    infix operator fun minus(operand:Rational): Rational =
        if(operand.d == this.d) Rational(operand.n-this.n, this.d)
        else Rational((this.n * operand.d) - operand.n * this.d, operand.d * this.d)

    infix operator fun times(operand:Rational): Rational =
        Rational(operand.n * this.n, operand.d * this.d)

    infix operator fun div(operand:Rational): Rational =
        Rational(operand.n * this.d, operand.d * this.n)

    infix fun equals(other: Rational): Boolean =
        this.n == other.n && this.d == other.d || this.n/this.d == other.n/other.d

    infix operator fun compareTo(other: Rational): Int {
        return when {
            ((this.n / this.d) >= (other.n / other.d)) -> 1
            ((this.n / this.d) < (other.n / other.d)) -> -1

            else -> 0
        }
    }

    infix fun rangeTo(other: IntRange): Boolean =


    infix fun contains(other: IntRange): Boolean =
        this.n/this.d > other.
}