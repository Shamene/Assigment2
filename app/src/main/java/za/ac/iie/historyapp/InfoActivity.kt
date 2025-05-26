package za.ac.iie.historyapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_info)


                val btnStart = findViewById<Button>(R.id.startQuizButton)
                btnStart.setOnClickListener {
                    val intent = Intent(this, QuizActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }


