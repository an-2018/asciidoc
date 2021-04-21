package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    var rightPosition = 0
    var wrongPosition = 0

    fun checkPosition(letter:Char, word:String){
        println(letter)
        if(letter !in word) {
            return
        }

        if (letter == word[0]){
            print(" right\n")
            rightPosition++
        }else {
            print(" wrong\n")
            wrongPosition++
        }
    }

    for(i in 0 until secret.length){

        checkPosition(guess[i], secret)
        guess = guess.substring(i)
    }

    return Evaluation(rightPosition, wrongPosition)
}
