package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    var rightPosition = 0
    var wrongPosition = 0
    var auxGuess = StringBuilder(4)

    fun isValid(letter:Char, index:Int, word:String){
        println(letter)
        var count = 0
        if(letter in word){
            for(i in word.indices){
                if(letter == guess[i]  && letter == secret[i]){
                    println("${guess[i]} right")
                    rightPosition++
                    count++
                    continue
                }
                if(letter != secret[i] ) {
                    println("$letter wrong pos")
                    wrongPosition++
                    break
                }
            }
            //println("${letter} wrong")
           // if(count == 0) wrongPosition++
        }
        /*for(i in index until word.length){
            if(letter in word){
                if(letter == word[i] && i == index) {
                    print("$letter is right" )
                    rightPosition++
                    break
                }
                print("$letter is wrong")
                wrongPosition++
                break
            }
        }*/
    }

    for((i,ch) in guess.withIndex()){
        if(auxGuess.contains(ch)) continue
        isValid(ch,i,secret)
        auxGuess.append(ch)
    }

    return Evaluation(rightPosition, wrongPosition)
}
