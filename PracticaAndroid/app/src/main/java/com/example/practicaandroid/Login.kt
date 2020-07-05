package com.example.practicaandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    /**/
    companion object{
        const val KEY_NOMBRE = "nombre"
        const val KEY_APELLIDO = "apellido"
        const val KEY_DNI = "dni"
        const val KEY_DIRECCION = "direccion"
        const val KEY_USUARIO = "usuario"
        const val KEY_CLAVE = "clave"
        const val KEY_CURSO = "TALLER_KOTLIN_FORM"
    }
    var nombre: String? = null
    var apellido: String? = null
    var dni : String? = null
    var direccion: String? = null
    var usuario: String? = null
    var clave: String? = null

    data class Usuario(val nombre:String?, val apellido:String?, val dni:String?, val direccion:String?, val usuario:String?, val clave:String?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val objUsuario: Usuario = opConstruirObjeto()

        usuario = objUsuario.usuario;
        clave = objUsuario.clave;
        println("Usuario: $usuario")


        btnIngresar.setOnClickListener { view ->
            if (txtUsuarioLogin.text.toString().equals(usuario) && txtClave.text.toString().equals(clave)){
                val intent = Intent(this, VerInformacion::class.java)
                intent.putExtra(KEY_NOMBRE,objUsuario.nombre)
                intent.putExtra(KEY_APELLIDO, objUsuario.apellido)
                intent.putExtra(KEY_DNI, objUsuario.dni)
                intent.putExtra(KEY_DIRECCION, objUsuario.direccion)
                startActivity(intent)
            }else
            {
                Snackbar.make(view, "Aviso: Usuario y/o Contraseña Incorrectos", Snackbar.LENGTH_LONG )
                    .setAction("Action", null).show()
            }
        }

        btnRegistro.setOnClickListener { view ->
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    private fun opConstruirObjeto() : Usuario {
        nombre = opObtener(KEY_NOMBRE) /*harold*/
        apellido = opObtener(KEY_APELLIDO) /*caballero*/
        dni = opObtener(KEY_DNI)
        direccion = opObtener(KEY_DIRECCION)
        usuario = opObtener(KEY_USUARIO)
        clave = opObtener(KEY_CLAVE)

        var objUsuario = Usuario(
            nombre, apellido, dni, direccion, usuario, clave
        )

        return objUsuario
    }

    private fun opObtener(key: String) : String? {
        val sharedPref = applicationContext.getSharedPreferences(KEY_CURSO, Context.MODE_PRIVATE)
        return sharedPref.getString(key, "none")
    }
}