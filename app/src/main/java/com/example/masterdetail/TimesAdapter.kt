package com.example.masterdetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class TimesAdapter (private val times: List<Time>,
                    private val context: Context,
                    private val click : (time: Time) -> Unit
                    ) : Adapter<TimesAdapter.TimesViewHolder>(){


    inner class TimesViewHolder(itemView: View): ViewHolder(itemView){
        val timeImage: ImageView = itemView.findViewById(R.id.timeImage)
        val timeName: TextView = itemView.findViewById(R.id.timeName)
        val timeEstado: TextView = itemView.findViewById(R.id.timeEstado)
        val timeDivisao: TextView = itemView.findViewById(R.id.timeDivisao)

        fun bind(time: Time){
            timeImage.setImageResource(time.imagem);
            timeName.text = time.nome;
            timeEstado.text = time.estado;
            timeDivisao.text = time.divisao;

            itemView.setOnClickListener{it
                click(time)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimesViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return TimesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TimesViewHolder, position: Int) {
        val time = times[position]
        holder.bind(time);
    }

    override fun getItemCount(): Int {
        return times.size
    }
}