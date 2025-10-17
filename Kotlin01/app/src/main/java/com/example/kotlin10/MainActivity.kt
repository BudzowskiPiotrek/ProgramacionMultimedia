package com.example.kotlin10

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin10.databinding.VentanaBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: VentanaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.ventana)
        binding = VentanaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val nro1 = binding.et1.text.toString().toIntOrNull() ?: 0
            val nro2 = binding.et2.text.toString().toIntOrNull() ?: 0
            val suma = nro1 + nro2
            binding.tv1.text = "Resultado: $suma"
        }
    }
}
