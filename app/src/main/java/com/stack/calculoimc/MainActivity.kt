package com.stack.calculoimc

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.stack.calculoimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btResultado.setOnClickListener { view ->
            val peso = binding.btPeso.editText?.text.toString()
            val altura = binding.btAltura.editText?.text.toString()

            val intent = Intent(this, TelaResultado::class.java)

            if(peso.isNotEmpty() && altura.isNotEmpty()) {

                intent.putExtra("Altura",altura.toDouble())
                intent.putExtra("Peso", peso.toDouble())
                startActivity(intent)
            }else {
                mensagem(view, "Preencha todos os campos", "#FF0000")

            }
        }
    }
    private fun mensagem(view: View, mensagem : String, cor : String){

        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor(cor))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()

    }
}
