package com.example.studentattendanceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la interfaz
        val etCodigo = findViewById<EditText>(R.id.etCodigo)
        val etNombres = findViewById<EditText>(R.id.etNombres)
        val etFecha = findViewById<EditText>(R.id.etFecha)
        val etCurso = findViewById<EditText>(R.id.etCurso)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            val codigo = etCodigo.text.toString().trim()
            val nombres = etNombres.text.toString().trim()
            val fecha = etFecha.text.toString().trim()
            val curso = etCurso.text.toString().trim()

            // Validación simple
            if (codigo.isEmpty() || nombres.isEmpty() || fecha.isEmpty() || curso.isEmpty()) {
                Toast.makeText(this, "Por favor complete todos los campos.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Construir mensaje
            val mensaje = """
                Asistencia registrada:
                
                Código: $codigo
                Nombre: $nombres
                Fecha: $fecha
                Curso: $curso
            """.trimIndent()

            // Mostrar AlertDialog
            AlertDialog.Builder(this)
                .setTitle("Confirmación")
                .setMessage(mensaje)
                .setPositiveButton("Aceptar") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}