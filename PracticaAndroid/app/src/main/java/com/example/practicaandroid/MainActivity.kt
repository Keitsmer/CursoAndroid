package com.example.practicaandroid

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGuardar.setOnClickListener { view ->
            opGuardar(txtNombre.text.toString(), txtApellidos.text.toString(),
                txtDni.text.toString(), txtDireccion.text.toString(),
                txtUsuario.text.toString(), txtPassword.text.toString())
            Snackbar.make(view, "Aviso: Datos Guardados correctamente", Snackbar.LENGTH_LONG )
                .setAction("Action", null).show()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        btnVerLista.setOnClickListener { view ->
            val intent = Intent(this, ListaUsuario::class.java)
            startActivity(intent)
        }

    }

    private fun opGuardar(nombre:String, apellidos:String, dni:String, direccion:String, usuario:String, clave:String ){
        val sharedPref = applicationContext.getSharedPreferences(Login.KEY_CURSO, Context.MODE_PRIVATE);
        val editor:SharedPreferences.Editor = sharedPref.edit()
        editor.putString(Login.KEY_NOMBRE, nombre)
        editor.putString(Login.KEY_APELLIDO, apellidos)
        editor.putString(Login.KEY_DNI, dni)
        editor.putString(Login.KEY_DIRECCION, direccion)
        editor.putString(Login.KEY_USUARIO, usuario)
        editor.putString(Login.KEY_CLAVE, clave)
        editor.apply()
    }
}