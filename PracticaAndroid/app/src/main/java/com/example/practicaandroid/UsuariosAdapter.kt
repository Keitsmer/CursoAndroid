package com.example.practicaandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_usuario.view.*

class UsuariosAdapter(items:ArrayList<Usuario>) : RecyclerView.Adapter<UsuariosAdapter.ViewHolder>() {

    var items : ArrayList<Usuario>? = null
    var viewHolder : ViewHolder? = null
    init {
        this.items = items
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuariosAdapter.ViewHolder {
        val vista = LayoutInflater.from(parent?.context).inflate(R.layout.item_usuario, parent, false)
        viewHolder = ViewHolder(vista)
        return viewHolder!!
    }

    override fun getItemCount(): Int {
        return this.items?.count()!!
    }

    override fun onBindViewHolder(holder: UsuariosAdapter.ViewHolder, position: Int) {
        var item = items?.get(position)
        holder.nombre?.text  = item?.nombre
        holder.apellido?.text = item?.apellido
        holder.dni?.text = item?.dni
        holder.direccion?.text = item?.direccion
        Picasso.with(holder.itemView.context)
            .load(item?.imagen)
            .centerCrop()
            .resize(100, 100)
            .into(holder.foto)

    }

    class ViewHolder(vista:View) : RecyclerView.ViewHolder(vista){
        var vista = vista
        var foto:ImageView? = null
        var nombre:TextView? = null
        var apellido:TextView? = null
        var dni:TextView? = null
        var direccion:TextView? = null

        init {
            foto =vista.imgFoto
            nombre = vista.tvNombre
            apellido = vista.tvApellidos
            dni = vista.tvDni
            direccion = vista.tvDireccion
        }
    }

}