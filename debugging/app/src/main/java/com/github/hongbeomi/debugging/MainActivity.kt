package com.github.hongbeomi.debugging

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        division()
    }

    private fun division() {
        val numerator = 60
        var denominator = 4
        thread(start = true) {
            repeat(4) {
                Thread.sleep(3000)
                runOnUiThread {
                    findViewById<TextView>(R.id.division_textview).text = "${numerator / denominator}"
                    denominator--
                }
            }
        }
    }

}