package za.ac.iie.historyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    // Declare UI elements
    private lateinit var txtQuestion: TextView
    private lateinit var txtFeedback: TextView
    private lateinit var imgPainting: ImageView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button

    // Quiz questions based on famous South African artworks
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

    // Tracking the quiz state
    private var currentIndex = 0
    private var score = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quiz)

                // Link UI elements from XML
                txtQuestion = findViewById<TextView>(R.id.txtQuestion)
                txtFeedback = findViewById<TextView>(R.id.txtFeedback)
                imgPainting = findViewById<ImageView>(R.id.imgReview)
                btnTrue = findViewById<Button>(R.id.btnTrue)
                btnFalse = findViewById<Button>(R.id.btnFalse)
                btnNext = findViewById<Button>(R.id.btnNext)

                // Load the first question when activity starts
                loadQuestion()

                // Check answer when TRUE is clicked
                btnTrue.setOnClickListener {
                    checkAnswer(true)
                }

                // Check answer when FALSE is clicked
                btnFalse.setOnClickListener {
                    checkAnswer(false)
                }

                // Proceed to next question or score screen
                btnNext.setOnClickListener {
                    currentIndex++
                    if (currentIndex < questions.size) {
                        loadQuestion()
                    } else {
                        // Move to the ScoreActivity and pass the score
                        val intent = Intent(this, ScoreActivity::class.java)
                        intent.putExtra("score", score)
                        intent.putExtra("total", questions.size)
                        startActivity(intent)
                        finish()
                    }
                }
            }

            // Loads the current question and image
            private fun loadQuestion() {
                txtQuestion.text = questions[currentIndex]
                imgPainting.setImageResource(imageIds[currentIndex])
                txtFeedback.text = ""
                answered = false
                btnNext.isEnabled = false
                btnTrue.isEnabled = true
                btnFalse.isEnabled = true
            }

            // Checks the user's answer and gives feedback
            private fun checkAnswer(userAnswer: Boolean) {
                if (!answered) {
                    val correct = answers[currentIndex]
                    if (userAnswer == correct) {
                        txtFeedback.text = "Correct!"
                        txtFeedback.setTextColor(resources.getColor(android.R.color.holo_green_dark))
                        score++
                    } else {
                        txtFeedback.text = "Incorrect!"
                        txtFeedback.setTextColor(resources.getColor(android.R.color.holo_red_dark))
                    }
                    answered = true
                    btnNext.isEnabled = true
                    btnTrue.isEnabled = false
                    btnFalse.isEnabled = false
                }
            }
        }





