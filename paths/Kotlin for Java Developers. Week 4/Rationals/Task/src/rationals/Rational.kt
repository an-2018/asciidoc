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
    // h
    println((-2 divBy 4).toString() )
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)

}

infix fun <T :Number> T.divBy(denominator: T):Rational{
    return Rational(this, denominator)
}

fun String.toRational():Rational {
    val params = this.split('/')
    return Rational(BigInteger(params[0]), BigInteger(params[1]))
}

class Rational(n:Number, d:Number) {
    var n: BigInteger = BigInteger.ZERO
    var d: BigInteger = BigInteger.ONE

    init {
        when(n){
            is Int -> this.n = n.toBigInteger()
            is Long -> this.n = n.toBigInteger()
            is BigInteger -> this.n = n
        }
        when (d){
            is Int -> this.d = d.toBigInteger()
            is Long -> this.d = d.toBigInteger()
            is BigInteger -> this.d = d
        }

        if (d == BigInteger.ZERO) {
            throw IllegalArgumentException()
        }

        val divisor =  this.n.gcd(this.d)
        if(divisor != BigInteger.ONE)  {this.n /= divisor; this.d/=divisor}

    }

    infix operator fun plus(operand: Rational): Rational =
        if (operand.d == this.d) Rational(operand.n + this.n, this.d)
        else Rational((this.n * operand.d) + operand.n * this.d, operand.d * this.d)

    infix operator fun minus(operand: Rational): Rational =
        if (operand.d == this.d) Rational(operand.n - this.n, this.d)
        else Rational((this.n * operand.d) - operand.n * this.d, operand.d * this.d)

    infix operator fun times(operand: Rational): Rational =
        Rational(operand.n * this.n, operand.d * this.d)

    infix operator fun div(operand: Rational): Rational {
        return Rational(this.n * operand.d, this.d * operand.n)
    }

    operator fun unaryMinus(): Rational = Rational(-this.n, this.d)

    override infix fun equals(that: Any?): Boolean {
        return (that is Rational) &&
                (this.n == that.n && this.d == that.d ||
                        this.n.toDouble() / this.d.toDouble() == that.n.toDouble() / that.d.toDouble())
    }

    infix operator fun compareTo(other: Rational): Int {
        return when {
            ((this.n / this.d) >= (other.n / other.d)) -> 1
            ((this.n / this.d) < (other.n / other.d)) -> -1

            else -> 0
        }
    }


    infix fun contains(other: Array<Rational>): Boolean =
        this.n > other.first().n && this.n < other.last().n


    operator fun rangeTo(other: Rational): Array<Rational?> {
        val range:LongRange = (this.n).toLong()..(other.n).toLong()
        val arr:Array<Rational?> = arrayOfNulls(range.count())
        for (c in (range).withIndex()){
            arr[c.index] = Rational(c.value.toBigInteger(),(other.d))
        }
        return arr
    }

    override fun hashCode(): Int {
        var result = n.hashCode()
        result = 31 * result + d.hashCode()
        return result
    }

    override fun toString():String{
        println("${this.n}/${this.d}")
        return if(this.d == BigInteger.ONE) "${this.n}" else "${this.n/this.d}"
    }

}

