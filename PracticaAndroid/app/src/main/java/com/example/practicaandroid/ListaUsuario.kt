package com.example.practicaandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_lista_usuario.*

class ListaUsuario : AppCompatActivity() {
    var usuario:ArrayList<Usuario>? = null
    var lista:RecyclerView? = null
    var layoutManager:RecyclerView.LayoutManager? = null
    var adaptador:UsuariosAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_usuario)

        usuario = ArrayList()
        usuario?.add(Usuario("Keitsmer Harold Smit", "Caballero Calderón", "46822580", "Trujillo", "https://e00-marca.uecdn.es/assets/multimedia/imagenes/2020/06/04/15912219730543.jpg"))
        usuario?.add(Usuario("Fernando", "Caballero Jimenez", "18071340", "Trujillo", "https://e00-marca.uecdn.es/assets/multimedia/imagenes/2020/06/04/15912219730543.jpg"))
        usuario?.add(Usuario("Micaela Pilar", "Calderón Agreda", "18074850", "Trujillo", "https://e00-marca.uecdn.es/assets/multimedia/imagenes/2020/06/04/15912219730543.jpg"))
        usuario?.add(Usuario("Sharon Lenda", "Caballero Calderón", "46822580", "Trujillo", "https://e00-marca.uecdn.es/assets/multimedia/imagenes/2020/06/04/15912219730543.jpg"))

        lista = findViewById(R.id.lstUsuarios)
        layoutManager = LinearLayoutManager(this)
        adaptador = UsuariosAdapter(usuario!!)
        lstUsuarios.adapter = adaptador
        lista?.layoutManager = layoutManager
        lista?.adapter = adaptador

    }
}