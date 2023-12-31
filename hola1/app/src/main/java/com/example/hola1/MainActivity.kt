package com.example.hola1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity() {
    private lateinit var valorResultado: EditText
    private var operadorActual = ""
    private var numeroActual = 0.0
    private var numeroAnterior = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        valorResultado = findViewById(R.id.Name)
        setupButtons()
    }
    private fun setupButtons() {
        val buttons = arrayOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9, R.id.btnpunto, R.id.btnigual,
            R.id.btnsum, R.id.btnrest, R.id.btnpor, R.id.btndividir,
            R.id.Result
        )
        for (buttonId in buttons) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener { onButtonClick(button) }
        }

    }
    private fun onButtonClick(view: View) {
        when (view.id) {
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
            R.id.btn8, R.id.btn9, R.id.btnpunto -> {
                val button = findViewById<Button>(view.id)
                appendToInput(button.text.toString())
            }
            R.id.btnsum, R.id.btnrest, R.id.btnpor, R.id.btndividir -> {
                val button = findViewById<Button>(view.id)
                setOperator(button.text.toString())
            }
            R.id.btnigual -> calculateResult()
            R.id.Result-> {
                valorResultado.text.clear()
                operadorActual=""
                numeroActual=0.0
                numeroAnterior=0.0
            }
        }
    }
    private fun appendToInput(value: String) {
        Log.v("VER", value.toString())
        valorResultado.append(value)
    }
    private fun setOperator(operator: String) {
        operadorActual = operator
        numeroAnterior = valorResultado.text.toString().toDouble()
        valorResultado.text.clear()
    }
    private fun calculateResult() {
        numeroActual = valorResultado.text.toString().toDouble()
        val result = when (operadorActual) {
            "+" -> numeroAnterior + numeroActual
            "-" -> numeroAnterior - numeroActual
            "*" -> numeroAnterior * numeroActual
            "/" -> numeroAnterior / numeroActual
            else -> numeroActual
        }
        valorResultado.setText(result.toString())
        operadorActual = ""
    }

}