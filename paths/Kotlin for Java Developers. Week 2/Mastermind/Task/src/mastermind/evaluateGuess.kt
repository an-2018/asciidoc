package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    var rightPosition = 0
    var wrongPosition = 0
    var aux = StringBuilder()

    fun checkPosition(index:Int, letter:Char, word:String){
        if(letter !in word) {
            return
        }
        for(i in word.indices){
            println(letter)
            if (letter == word[i] && i == index){
                print(" right\n")
                rightPosition++
                continue
            }
            if(letter == word[i]){
                println("wro")
                wrongPosition++
                break
            }
        }
        /*else {
            print(" wrong\n")
            wrongPosition++
        }*/
    }

    for(i in guess.indices){

        if(aux.contains(guess[i])) {
            continue
        }

        checkPosition(i, guess[i], secret)
        aux.append(guess[i])
    }

    return Evaluation(rightPosition, wrongPosition)
}
