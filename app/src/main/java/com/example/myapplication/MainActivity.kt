package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.coroutines.*
import androidx.lifecycle.lifecycleScope



class MainActivity : AppCompatActivity() {

    private var num: Int = 0

    private lateinit var button: Button
    private lateinit var input: EditText
    private lateinit var output: TextView

    private var prova = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)

        button = findViewById(R.id.uno)
        input = findViewById(R.id.due)
        output = findViewById(R.id.tre)

    }

    override fun onStart() {
        super.onStart()


        button.setOnClickListener {
            if (prova) {
                num = input.text.toString().toInt()
                output.text = num.toString()
                prova = false
            } else {
                output.text = num.toString()
            }
            lifecycleScope.launch {
                process()

            }

        }
    }

    private suspend fun process() {

        delay(2000)
        num++
        withContext(Dispatchers.Main) {
            output.text = num.toString() }
    }
}