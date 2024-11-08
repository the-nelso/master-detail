package com.example.masterdetail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MasterActivity : AppCompatActivity() {
    private lateinit var recyclerViewTimes: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_master)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerViewTimes = findViewById<RecyclerView>(R.id.TimesRV);

        // ADAPTER AQUI

        recyclerViewTimes.layoutManager = LinearLayoutManager(this);
        recyclerViewTimes.setHasFixedSize(true);
        recyclerViewTimes.addItemDecoration(
            DividerItemDecoration(this, RecyclerView.VERTICAL)
        )
    }

    private fun criarTimes() : List<Time>{
        return listOf(
            Time("Coritiba", "Paraná", "Segunda Divisão", R.drawable.coritiba),
            Time("Atlético Paranaense", "Paraná", "Primeira Divisão", R.drawable.atleticopr),
            Time("Guarani", "São Paulo", "Segunda Divisão", R.drawable.guarani),
            Time("Paraná Clube", "Paraná", "Quarta Divisão", R.drawable.parana),
            Time("Londrina", "Paraná", "Terceira Divisão", R.drawable.londrina),
            Time("Flamengo", "Rio de Janeiro", "Primeira Divisão", R.drawable.flamengo),
        )
    }
}