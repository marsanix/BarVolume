package com.example.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var inputLength: EditText
    private lateinit var inputWidth: EditText
    private lateinit var inputHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var txtResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputLength = findViewById(R.id.inputLength)
        inputWidth = findViewById(R.id.inputWidth)
        inputHeight = findViewById(R.id.inputHeight)
        btnCalculate = findViewById(R.id.btnCalculate)
        txtResult = findViewById(R.id.txtResult)

        btnCalculate.setOnClickListener(this)

        if(savedInstanceState != null) {
            val stateResult = savedInstanceState.getString("state_result")
            txtResult.text = stateResult
        }
    }

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btnCalculate) {

            val length = inputLength.text.toString().trim()
            val width = inputWidth.text.toString().trim()
            val height = inputHeight.text.toString().trim()

            var isEmptyFields = false

            if(length.isEmpty()) {
                isEmptyFields = true
                inputLength.error = "The Length field is not allowed to empty"
            }

            if(width.isEmpty()) {
                isEmptyFields = true
                inputWidth.error = "The Width field is not allowed to empty"
            }

            if(height.isEmpty()) {
                isEmptyFields = true
                inputHeight.error = "The Height field is not allowed to empty"
            }

            if(!isEmptyFields) {
                val volume = length.toDouble() * width.toDouble() * height.toDouble()
                txtResult.text = volume.toString()
            }

        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

        outState.putString("state_result", txtResult.text.toString())
    }
}