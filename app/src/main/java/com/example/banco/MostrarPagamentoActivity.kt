package com.example.banco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MostrarPagamentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_pagamento)
        setSupportActionBar(findViewById(R.id.toolpagar))
        val saldo = intent.getStringExtra("sSaldo")
        var nsaldo = saldo.toString().toDouble()
        val btpagar = findViewById<Button>(R.id.btnpagamento)
        val edtpagar = findViewById<EditText>(R.id.ValorPagar)
        btpagar.setOnClickListener {
            val data = Intent()
            val edtpagar = findViewById<EditText>(R.id.ValorPagar)
            val nvalor = edtpagar.text.toString().toDouble()
            if(nsaldo<nvalor) {
                Toast.makeText(this, "Saldo de $nsaldo é insuficiente para o valor de $nvalor",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {
                nsaldo -= nvalor
            }
            if(nsaldo>nvalor) {
                val LENGTH_SHORT = 0
                Toast.makeText(this, "Pagamento realizado com sucesso", Toast.LENGTH_SHORT).show()
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK,data)
            Toast.makeText(this, "$nsaldo", Toast.LENGTH_SHORT).show()
            edtpagar.setText("".toString())
            finish()
        }
    }
    }
}