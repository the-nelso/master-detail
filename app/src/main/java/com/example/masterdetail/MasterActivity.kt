package com.example.masterdetail

import android.content.Context
import android.os.Bundle
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class MasterActivity : AppCompatActivity() {
    private lateinit var recyclerViewTime: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_master)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

class Time(val nome: String, val estado: String, val divisao: String){}

class TimesAdapter(private val times: List<Time>, private val context: Context): Adapter<TimesAdapter.TimesViewHolder>(){}


class TimesAdapter(private val times: List<Time>): Adapter<TimesAdapter.TimesViewHolder>(){
    inner class TimesViewHolder(itemView: ItemView): ViewHolder(itemView){
        val timeImage: ImageView = itemView.findViewById(R.id.timeImage)
        val timeName: TextView = itemView.findViewById(R.id.timeName)
        val timeEstado: TextView = itemView.findViewById(R.id.timeEstado)
        val timeDivisao: TextView = itemView.findViewById(R.id.timeDivisao)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimesViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return TimesViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: TimesViewHolder, position: Int) {
        val time = times[position]
        holder.timeImage.setImageResource(time.imagem)
        holder.timeName.text = time.nome
        holder.timeEstado.text = time.estado
        holder.timeDivisao.text = time.divisao
    }
    override fun getItemCount(): Int {
        return times.size
    }
}