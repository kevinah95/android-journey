enum class Difficulty {
    EASY, MEDIUM, HARD
}

data class Question<T>(
	val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
	
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
    
    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}

val Quiz.StudentProgress.progressText: String
	get() = "${answered} of ${total} answered"

fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)
}



/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun main() {
    
    //println("${Quiz.answered} of ${Quiz.total} answered.")
    //println(Quiz.progressText)
    Quiz.printProgressBar()
    Quiz().apply {
        printQuiz()
    }
}