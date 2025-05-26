package za.ac.iie.historyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    private lateinit var txtScore: TextView
    private lateinit var btnRestart: Button
    private lateinit var btnReviewAnswers: Button
    private lateinit var txtFinalMessage : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        // Get score and total from intent
        val score = intent.getIntExtra("score", 0)
        val total = intent.getIntExtra("total", 0)

        // Link UI elements
        txtScore = findViewById<TextView>(R.id.txtScore)
        txtFinalMessage= findViewById<TextView>(R.id.txtFinalMessage)
        btnReviewAnswers = findViewById<Button>(R.id.btnReview)
        btnRestart = findViewById(R.id.btnRestart)

        // Display score
        txtScore.text = "You scored $score out of $total"

        // Display custom final message
        val message = when {
            score == total -> "Outstanding! You’re an art history genius!"
            score >= total * 0.7 -> "Well done! You have a strong knowledge of African art."
            score >= total * 0.4 -> "Good effort! You’re learning, keep exploring."
            else -> "Keep going! Every great artist starts somewhere."
        }
        txtFinalMessage.text = message

        // Review answers button
        btnReviewAnswers.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }

        // Restart quiz button
        btnRestart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}




