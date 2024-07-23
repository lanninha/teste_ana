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

class MainActivity3 : AppCompatActivity() {
    private lateinit var textoSenha1: EditText
    private lateinit var textoSenha2: EditText
    private lateinit var imagemMostrarSenha1: ImageView
    private lateinit var    imagemMostarSenha2 : ImageView

    private var senhaVisivel1:Boolean = false
    private var senhaVisivel2:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val botao: Button = findViewById(R.id.button3)

        textoSenha1 = findViewById(R.id.editTextTextPassword1)
        imagemMostrarSenha1 = findViewById(R.id.imagemMostrarSenha1)

        textoSenha2 = findViewById(R.id.editTextTextPassword2)
        imagemMostarSenha2 = findViewById(R.id.imagemMostrarSenha2)

        imagemMostrarSenha1.setOnClickListener {
            senhaVisivel1 = !senhaVisivel1
            alternarVisibilidadeSenha(textoSenha1,imagemMostrarSenha1,senhaVisivel1)
        }

        imagemMostarSenha2.setOnClickListener {
            senhaVisivel2 = !senhaVisivel2
            alternarVisibilidadeSenha(textoSenha2 , imagemMostarSenha2,senhaVisivel2)
        }
        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#EFD6C1")

        botao.setOnClickListener{
            val segundaTela = Intent(this, MainActivity4::class.java)
            startActivity(segundaTela)
        }
    }
    private fun alternarVisibilidadeSenha(textoSenha :EditText , imagemMostrarSenha: ImageView, senhaVisivel:Boolean) {
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