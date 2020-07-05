package com.example.practicaandroid

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_ver_informacion.*

class VerInformacion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_informacion)

        txtDNombre.setText(intent.getStringExtra(Login.KEY_NOMBRE))
        txtDApellidos.setText(intent.getStringExtra(Login.KEY_APELLIDO))
        txtDDni.setText(intent.getStringExtra(Login.KEY_DNI))
        txtDDireccion.setText(intent.getStringExtra(Login.KEY_DIRECCION))

        btnEditar.setOnClickListener { view ->
            opModificar(txtDNombre.text.toString(), txtDApellidos.text.toString(), txtDDni.text.toString(), txtDDireccion.text.toString())
            /*Snackbar.make(view, "Aviso: Actualización correcta.", Snackbar.LENGTH_LONG )
                .setAction("Action", null).show()*/
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

    }

    private fun opModificar(nombre:String, apellidos:String, dni:String, direccion:String){
        val sharedPref = applicationContext.getSharedPreferences(Login.KEY_CURSO, Context.MODE_PRIVATE);
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(Login.KEY_NOMBRE, nombre)
        editor.putString(Login.KEY_APELLIDO, apellidos)
        editor.putString(Login.KEY_DNI, dni)
        editor.putString(Login.KEY_DIRECCION, direccion)
        editor.apply()
    }

}