package com.github.hongbeomi.debugging

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.concurrent.thread

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        division()
//        divisionForDebugging()
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

    /**
     * 중단점에 조건을 추가하여 특정 조건에 걸릴 경우에만 디버깅이 가능하다.
     * 디버그 창에서 Watches 항목을 추가하여 특정 변수를 모니터링할 수 있다.
     */
    private fun divisionForDebugging() {
        val numerator = 60
        var denominator = 4
        repeat(5) {
            Log.v(TAG, "${numerator / denominator}")
            denominator--
        }
    }

}