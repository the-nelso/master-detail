package com.example.masterdetail;
import androidx.appcompat.view.menu.MenuView.ItemView;
import android.widget.Adapter;
import android.content.Context;


public class TimesAdapter(private val times: List<Time>,  private val context: Context): Adapter<TimesAdapter.TimesViewHolder>(){
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