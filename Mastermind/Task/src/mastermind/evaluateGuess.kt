package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val rightPosition = secret.zip(guess).count { it.first == it.second }
    val wrongPosition = "ABCDEF".sumBy { letter ->
        Math.min(secret.count { it == letter }, guess.count { it == letter })
    }

    return Evaluation(rightPosition, wrongPosition - rightPosition)
}

