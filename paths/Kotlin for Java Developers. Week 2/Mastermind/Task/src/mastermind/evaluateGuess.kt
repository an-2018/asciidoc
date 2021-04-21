package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    var rightPositions = 0
    var wrongPositions = 0
    var aux = StringBuilder()

    fun findOccurencies(c:Char, word:String):Int{
        var num = 0
        for(char in word){
            if(char == c){
                num++
            }
        }
        return num
    }

    for(i in secret.indices){

        if(guess[i] !in secret){
            continue
        }

        if(guess[i] == secret[i]){
            println("${guess[i]} right")
            rightPositions++
            continue
        }

        for(j in secret.indices){
            if(guess[j] == secret[j]) continue
            if(aux.contains(guess[i])){
                continue
            }
            println(guess[i])
            if(guess[i] == secret[j] && i != j){
                println("wrong")
                aux.append(guess[i])
                wrongPositions++
            }
        }
    }

    return Evaluation(rightPositions, wrongPositions)
}
