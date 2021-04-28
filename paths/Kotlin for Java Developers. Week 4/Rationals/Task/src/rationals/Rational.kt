package rationals

import java.math.BigInteger

fun main() {
    val half = 1 divBy 2
    val third = 1 divBy 3
/*
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
    */
    println("117/1098".toRational().toString() == "13/122")

    val twoThirds = 2 divBy 3
    println(half < twoThirds)

    println(half in third..twoThirds)
    val test = third..twoThirds
    println((third..twoThirds).contains(half))

    println(2000000000L divBy 4000000000L == 1 divBy 2)

    println("912016490186296920119201192141970416029".toBigInteger() divBy
            "1824032980372593840238402384283940832058".toBigInteger() == 1 divBy 2)

}

infix fun <T :Number> T.divBy(denominator: T):Rational{
    return Rational(this, denominator)
}

infix operator fun Array<Rational?>.contains(that: Rational?): Boolean {
    val thisN = this.first()!!.n.toDouble()
    val thisD = this.first()!!.d.toDouble()
    val thisLastN = this.last()!!.n.toDouble()
    val thisLastD = this.last()!!.d.toDouble()
    val thatN = that!!.n.toDouble()
    val thatD = that.d.toDouble()
    println("this ${thisN}/${thisD} this last ${thisLastN}/${thisLastD} that ${thatN}/${thatD}")
return thisN/thisD <= thatN/thatD  && thisLastN/thisLastD >= thatN/thatD
}

fun String.toRational():Rational {
    val params = this.split('/')
    return Rational(BigInteger(params[0]), if(params.size>1) BigInteger(params[1]) else BigInteger.ONE)
}

class Rational(n:Number, d:Number):Comparable<Rational> {
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
        if(divisor != BigInteger.ONE)  {
            this.n /= divisor; this.d/=divisor
        }
        if(this.n < BigInteger.ZERO && this.d < BigInteger.ZERO) {
            println("negative")
            this.n=-this.n;this.d=-this.d
        }else if(this.d < BigInteger.ZERO) {
            println("negative")
            this.n=-this.n;this.d=-this.d}

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

    override infix operator fun compareTo(other: Rational): Int {
        return when {
            ((this.n.toDouble() / this.d.toDouble()) > (other.n.toDouble()/ other.d.toDouble())) -> 1
            ((this.n.toDouble()/this.d.toDouble()) < (other.n.toDouble() / other.d.toDouble())) -> -1
            else -> 0
        }
    }

    override fun hashCode(): Int {
        var result = n.hashCode()
        result = 31 * result + d.hashCode()
        return result
    }

    override fun toString():String{
        return if(this.d == BigInteger.ONE) "${this.n}" else "${this.n}/${this.d}"
    }

    operator fun rangeTo(that: Rational): RationalRange<Rational>{
        return RationalRange(this,that)
    }
}

class RationalRange<Rational:Comparable<Rational>>(
    override val start:Rational,
    override val endInclusive: Rational
) : ClosedRange<Rational>


