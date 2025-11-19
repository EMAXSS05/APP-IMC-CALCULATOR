package com.example.appimccalculator

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class ImcCalculatorFragment : Fragment() {


    private var pesoActual = 1
    private var edadActual=1

    // Referencias a las vistas que vamos a manipular
    private lateinit var tvPeso: TextView

    private lateinit var tvEdad: TextView
    private lateinit var btnSumarEdad: FloatingActionButton
    private lateinit var btnRestarEdad: FloatingActionButton

    private lateinit var btnSumarPeso: FloatingActionButton
    private lateinit var btnRestarPeso: FloatingActionButton

    private lateinit var slide : RangeSlider

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_imc_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Encontrar las vistas usando su ID
        tvPeso = view.findViewById(R.id.tvPeso)
        btnSumarPeso = view.findViewById(R.id.btnSumarPeso)
        btnRestarPeso = view.findViewById(R.id.btnRestarPeso)
        tvEdad= view.findViewById(R.id.tvEdad)
        btnRestarEdad= view.findViewById(R.id.btnRestarEdad)
        btnSumarEdad= view.findViewById(R.id.btnSUmarEdad)
        slide= view.findViewById(R.id.slide)

        // 2. Actualizar la UI con el valor inicial
        actualizarTextoPeso()
        actualizarTextoEdad()

        // 3. Configurar el listener para el botón de sumar
        btnSumarPeso.setOnClickListener {
            // Incrementamos el valor
            pesoActual += 1
            // Actualizamos el texto en la pantalla
            actualizarTextoPeso()
        }

        // 4. Configurar el listener para el botón de restar (¡te lo añado como extra!)
        btnRestarPeso.setOnClickListener {
            // Solo restamos si el peso es mayor que 0
            if (pesoActual > 1) {
                // Decrementamos el valor
                pesoActual -= 1
                // Actualizamos el texto en la pantalla
                actualizarTextoPeso()
            }
        }

        btnRestarEdad.setOnClickListener {
            if (edadActual >1){
                edadActual -=1
                actualizarTextoEdad()
            }
        }

        btnSumarEdad.setOnClickListener {
            if (edadActual >=1 && edadActual <100){
                edadActual +=1
                actualizarTextoEdad()
            }
        }

        slide.valueFrom=100f
        slide.valueTo=210f
        slide.values= listOf(120f)

        slide.addOnChangeListener {slider,_,_ ->


            val altura = view.findViewById<TextView>(R.id.altura)
            altura.text= "${slider.values[0].toInt()} cm"







        }
        val colorNormal= Color.parseColor("#2F2D2D")
        val colorSeleccionado= Color.parseColor("#4B00FF")
        var generoSeleccionado: String? = null

        val cardHombre= view.findViewById<ConstraintLayout>(R.id.hombre)
        val cardMujer= view.findViewById<ConstraintLayout>(R.id.mujer)

        cardHombre.setOnClickListener {
            generoSeleccionado = "HOMBRE"
            cardHombre.setBackgroundColor(colorSeleccionado)
            cardMujer.setBackgroundColor(colorNormal)
        }

        cardMujer.setOnClickListener {
            generoSeleccionado = "MUJER"
            cardMujer.setBackgroundColor(colorSeleccionado)
            cardHombre.setBackgroundColor(colorNormal)
        }

        val btnCalcular = view.findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            val peso = pesoActual
            val alturaCm = slide.values[0].toInt()

            // Creamos la acción generada por Safe Args
            val action = ImcCalculatorFragmentDirections
                .actionImcCalculatorFragmentToResultIMCFragment(
                    peso = peso,
                    alturaCm = alturaCm
                )

            // Navegamos al fragment de resultados
            findNavController().navigate(action)
        }
    }
    private fun actualizarTextoPeso() {
        tvPeso.text = pesoActual.toString()
    }

    private fun actualizarTextoEdad(){
        tvEdad.text= edadActual.toString()
    }





}