

package com.example.calculadorapromedio

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textViewEstatus: TextView
    private lateinit var editTextNumberSis: EditText
    private lateinit var editTextNumberAlg: EditText
    private lateinit var editTextNumberSop: EditText
    private lateinit var editTextNumberPro: EditText
    private lateinit var textViewResultado: TextView
    private lateinit var buttonCalcular: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewEstatus = findViewById(R.id.textViewEstatus)
        editTextNumberSis = findViewById(R.id.editTextNumberSis)
        editTextNumberAlg = findViewById(R.id.editTextNumberAlg)
        editTextNumberSop = findViewById(R.id.editTextNumberSop)
        editTextNumberPro = findViewById(R.id.editTextNumberPro)
        textViewResultado = findViewById(R.id.textViewResultado)
        buttonCalcular = findViewById(R.id.buttonCalcular)

        buttonCalcular.setOnClickListener {
            val sis = editTextNumberSis.text.toString().trim()
            val alg = editTextNumberAlg.text.toString().trim()
            val sop = editTextNumberSop.text.toString().trim()
            val pro = editTextNumberPro.text.toString().trim()

            if (sis.isEmpty()){
                editTextNumberSis.error = "Digite la nota"
                textViewResultado.text = "No admite campos en blanco"
            }

            if (alg.isEmpty()){
                editTextNumberAlg.error = "Digite la nota"
                textViewResultado.text = "No admite campos en blanco"
            }

            if (sop.isEmpty()){
                editTextNumberSop.error = "Digite la nota"
                textViewResultado.text = "No admite campos en blanco"
            }

            if (pro.isEmpty()){
                editTextNumberPro.error = "Digite la nota"
                textViewResultado.text = "No admite campos en blanco"
            }

            try {
                val a = sis.toInt()
                val b = alg.toInt()
                val c = sop.toInt()
                val d = pro.toInt()
                if (a < 0 || a > 10){
                    editTextNumberSis.error = "Notas de 0 - 10"
                    textViewResultado.text = "Digite solo notas de 0 - 10"
                }

                if(b < 0 || b > 10){
                    editTextNumberAlg.error = "Notas de 0 - 10"
                    textViewResultado.text = "Digite notas de 0 - 10"
                }

                if (c < 0 || c > 10){
                    editTextNumberSop.error = "Notas de 0 - 10"
                    textViewResultado.text = "Digite notas de 0 - 10"
                }

                if (d < 0 || d > 10){
                    editTextNumberPro.error = "Notas de 0 - 10"
                    textViewResultado.text = "Digite notas de 0 - 10"
                }

                val suma = a + b + c + d
                val promedio = suma / 4.0
                if (promedio >= 7) {
                    textViewResultado.text = "Aprobado"
                }else textViewResultado.text = "Re-Probado"

            }catch (e: NumberFormatException){
                textViewResultado.text = "Digitar notas válidas 0 - 10"
            }
        }
    }
}