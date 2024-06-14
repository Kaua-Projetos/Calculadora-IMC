package com.stack.calculoimc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.stack.calculoimc.databinding.ActivityMainBinding
import com.stack.calculoimc.databinding.ActivityTelaResultadoBinding
import kotlin.time.times

class TelaResultado : AppCompatActivity() {
    private lateinit var binding : ActivityTelaResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityTelaResultadoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val bundle = intent.extras
        if(bundle != null){

            val peso = bundle.getDouble("Peso")
            val altura = bundle.getDouble("Altura")

            binding.txtPeso.text = "Peso: $peso kg"
            binding.txtAltura.text = "Altura: $altura m"

            var imc = peso / (altura * altura)

            if(imc <= 18.5){

                binding.txtResultado.text = "Baixo"
            }
            if(imc >=18.6 && imc <=24.9){

                binding.txtResultado.text = "Normal"
            }
            if(imc >=25.0 && imc <=29.9){

                binding.txtResultado.text = "Sobrepeso"
            }
            if(imc >=30.0 && imc <=39.9){

                binding.txtResultado.text = "Obesidade"
            }
        }

    }
}