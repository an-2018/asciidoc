package nicestring

fun String.isNice(): Boolean {

    val vowels = listOf('a','e','i','o','u')
    val substr = listOf("bu", "ba", "be")
    val numVowels = this.filter{it in vowels}.count()

    val sub = this.zipWithNext().filter{(first, second) -> "$first$second" in substr}.none()
    val seq = this.zipWithNext().filter{(first, second) -> first == second}.any()
    println("sub $sub")
    println(this.zipWithNext().filter{(first, second) -> first !in vowels && second in vowels})
    println("seq $seq")
    println(this.zipWithNext().filter{(first, second) -> first == second})
    println("Num vowels is $numVowels")
    val result = listOf(numVowels>=3,sub, seq)

    return result.filter{ it }.count() >= 2
}
