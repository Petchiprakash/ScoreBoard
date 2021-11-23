package com.example.scoreboard

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var countA =0
    private var countB =0
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences = getSharedPreferences("mypref", MODE_PRIVATE)
        btReset.setOnClickListener{
            tvAboard.text= countA.toString()
            tvBboard.text= countB.toString()
        }
        btA1run.setOnClickListener{
            countA++
            tvAboard.text= countA.toString()
        }
        btB1run.setOnClickListener{
            countB++
            tvBboard.text= countB.toString()

        }
        btA2run.setOnClickListener{
            countA += 2
            tvAboard.text= countA.toString()

        }
        btB2run.setOnClickListener{
            countB+=2
            tvBboard.text= countB.toString()
        }
        btA3run.setOnClickListener{
            countA+=3
            tvAboard.text= countA.toString()

        }
        btB3run.setOnClickListener{
            countB+=3
            tvBboard.text= countB.toString()

        }
        btA4run.setOnClickListener{
            countA+=4
            tvAboard.text= countA.toString()

        }
        btB4run.setOnClickListener{
            countB+=4
            tvBboard.text= countB.toString()

        }
        btA6run.setOnClickListener{
            countA+=6
            tvAboard.text= countA.toString()

        }
        btB6run.setOnClickListener{
            countB+=6
            tvBboard.text= countB.toString()

        }
        btAnoball.setOnClickListener{
            countA++
            tvAboard.text= countA.toString()

        }
        btBnoball.setOnClickListener{
            countB++
            tvBboard.text= countB.toString()

        }
        btAwide.setOnClickListener{
            countA++
            tvAboard.text= countA.toString()

        }
        btBwide.setOnClickListener{
            countB++
            tvBboard.text= countB.toString()

        }
    }

    override fun onPause() {
        super.onPause()
        val editor = sharedPreferences.edit()
        val cA = tvAboard.text.toString().toInt()
        val cB = tvBboard.text.toString().toInt()
        editor.apply{
            putInt("c1",cA)
            putInt("c2",cB)
            apply()
        }

    }
    override fun onResume() {
        super.onResume()
        val cA = sharedPreferences.getInt("c1",0)
        val cB = sharedPreferences.getInt("c2",0)
        tvAboard.text = cA.toString()
        tvBboard.text = cB.toString()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_TEAM_A_SCORE,countA)
        outState.putInt(KEY_TEAM_B_SCORE,countB)
    }
    companion object {
        const val KEY_TEAM_A_SCORE = "KEY_TEAM_A_SCORE"
        const val KEY_TEAM_B_SCORE = "KEY_TEAM_B_SCORE"
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        countA=savedInstanceState.getInt(KEY_TEAM_A_SCORE)
        countB=savedInstanceState.getInt(KEY_TEAM_B_SCORE)
        tvAboard.text = countA.toString()
        tvBboard.text = countB.toString()

    }

}