package com.example.appimccalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class ImcCalculatorFragment : Fragment() {

    // La inicializamos en 0, como pediste.
    private var pesoActual = 0

    // Referencias a las vistas que vamos a manipular
    private lateinit var tvPeso: TextView
    private lateinit var btnSumarPeso: Button
    private lateinit var btnRestarPeso: Button

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

        // 2. Actualizar la UI con el valor inicial
        actualizarTextoPeso()

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
            if (pesoActual > 0) {
                // Decrementamos el valor
                pesoActual -= 1
                // Actualizamos el texto en la pantalla
                actualizarTextoPeso()
            }
        }
    }
    private fun actualizarTextoPeso() {
        tvPeso.text = pesoActual.toString()
    }


}