package za.ac.iie.historyapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var txtReviewQuestion: TextView
    private lateinit var txtCorrectAnswer: TextView
    private lateinit var imgReview: ImageView
    private lateinit var btnNextReview: Button


    // Quiz Review questions based on famous South African artworks
    private val questions = arrayOf(
        "The Black Christ” by Ronald Harrison depicted Chief Albert Luthuli as a black Christ, symbolizing the struggle against apartheid.",
        "Jane Alexander’s “The Butcher Boys” was a sculpture that symbolized the resilience and triumph of apartheid’s victims.",
        "“Homage to Steve Biko” by Willie Bester used mixed media, including metal and scrap materials, to honor the anti-apartheid activist.",
        "Dumile Feni’s “History” series used smooth, lifelike sculptures to depict the struggle and trauma of apartheid.",
        "Gerard Sekoto’s “The Blue Head” was a piece of social realism that depicted life under apartheid, and Sekoto became the first black artist to gain international recognition."
    )

    // Corresponding answers to the above questions (True/False)
    private val answers = arrayOf(true, false, true, false, true)

    // Images associated with each question — make sure these are in res/drawable folder
    private val imageIds = arrayOf(
        R.drawable.black_christ,
        R.drawable.butcher_boys,
        R.drawable.homage_biko,
        R.drawable.dumile_history,
        R.drawable.blue_head
    )

    // Index to keep track of current question
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review)

        // Link XML UI elements to Kotlin code
        txtReviewQuestion = findViewById<TextView>(R.id.txtReviewQuestion)
        txtCorrectAnswer = findViewById<TextView>(R.id.txtCorrectAnswer)
        imgReview = findViewById<ImageView>(R.id.imgReview)
        btnNextReview = findViewById<Button>(R.id.btnNextReview)

        // Display the first review question
        showReview()

        // Set click listener for "Next" button
        btnNextReview.setOnClickListener {
            index++
            // If more questions remain, show the next one
            if (index < questions.size) {
                showReview()
            } else {
                // If done, close the review activity
                finish()
            }
        }
    }

    // Function to display question, correct answer, and image
    private fun showReview() {
        txtReviewQuestion.text = questions[index]
        txtCorrectAnswer.text = "Correct Answer: ${if (answers[index]) "True" else "False"}"
        imgReview.setImageResource(imageIds[index])
    }
}

