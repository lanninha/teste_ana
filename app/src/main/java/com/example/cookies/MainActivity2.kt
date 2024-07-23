package com.example.cookies

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    private lateinit var textoSenha: EditText
    private lateinit var imagemMostrarSenha: ImageView

    private var senhaVisivel: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val texto:TextView = findViewById(R.id.textView3)
        val botao:Button = findViewById(R.id.button1)

        textoSenha = findViewById(R.id.editTextTextPassword)
        imagemMostrarSenha = findViewById(R.id.imagemMostrarSenha)

        imagemMostrarSenha.setOnClickListener {
            senhaVisivel = !senhaVisivel
            alternarVisibilidadeSenha()
        }

        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#EFD6C1")

        texto.setOnClickListener{
            val segundaTela = Intent(this, MainActivity3::class.java)
            startActivity(segundaTela)
        }

        botao.setOnClickListener{
            val telaLogin = Intent(this, MainActivity4::class.java)
            startActivity(telaLogin)
        }
    }

    private fun alternarVisibilidadeSenha() {
        if (senhaVisivel) {
            // Mostrar senha
            textoSenha.transformationMethod = HideReturnsTransformationMethod.getInstance()
            imagemMostrarSenha.setImageResource(R.drawable.eye)
        } else {
            // Esconder senha
            textoSenha.transformationMethod = PasswordTransformationMethod.getInstance()
            imagemMostrarSenha.setImageResource(R.drawable.olhinhofechado)
        }

        // Move o cursor para o final do texto
        textoSenha.setSelection(textoSenha.text.length)
    }
}