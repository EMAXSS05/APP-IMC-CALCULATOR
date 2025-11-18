package com.example.appimccalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
    }
    private fun actualizarTextoPeso() {
        tvPeso.text = pesoActual.toString()
    }

    private fun actualizarTextoEdad(){
        tvEdad.text= edadActual.toString()
    }


}