package com.example.appimccalculator

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.appimccalculator.databinding.FragmentResultIMCBinding

class ResultIMCFragment : Fragment() {

    private var _binding: FragmentResultIMCBinding? = null
    private val binding get() = _binding!!

    // Recibir argumentos usando Safe Args
    private val args: ResultIMCFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultIMCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Tomamos los valores del fragment anterior
        val peso = args.peso
        val alturaCm = args.alturaCm

        // Calculamos IMC
        val alturaM = alturaCm / 100.0
        val imc = peso / (alturaM * alturaM)

        // Mostramos el IMC con 2 decimales
        binding.tvIMC.text = "IMC: %.2f".format(imc)

        // Clasificación con colores
        when {
            imc < 18.5 -> {
                binding.tvClasificacion.text = "Bajo peso"
                binding.tvClasificacion.setTextColor(Color.BLUE)
                binding.reflexion.text="Tu peso está por debajo de lo recomendado para tu altura. Es importante cuidar tu alimentación y consultar a un especialista si lo necesitas.\""
            }
            imc < 25.0 -> {
                binding.tvClasificacion.text = "Peso normal"
                binding.tvClasificacion.setTextColor(Color.GREEN)
                binding.reflexion.text="¡Excelente! Tu peso está dentro del rango saludable para tu altura. Sigue manteniendo hábitos de vida saludables."
            }
            imc < 30.0 -> {
                binding.tvClasificacion.text = "Sobrepeso"
                binding.tvClasificacion.setTextColor(Color.YELLOW)
                binding.reflexion.text="Tu peso está por encima de lo óptimo para tu altura. Intenta mantener una alimentación equilibrada y actividad física regular."
            }
            else -> {
                binding.tvClasificacion.text = "Obesidad"
                binding.tvClasificacion.setTextColor(Color.RED)
                binding.reflexion.text="Tu peso está considerablemente por encima del rango saludable para tu altura. Se recomienda consultar a un especialista y cuidar tu alimentación y actividad física.\""
            }
        }

        // Botón para volver
        binding.btnVolver.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
