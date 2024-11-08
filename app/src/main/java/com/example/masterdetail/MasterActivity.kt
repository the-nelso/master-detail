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

        recyclerViewTimes = findViewById<RecyclerView>(R.id.timesRV);

        // ADAPTER AQUI

        recyclerViewTimes.layoutManager = LinearLayoutManager(this);
        recyclerViewTimes.setHasFixedSize(true);
        recyclerViewTimes.addItemDecoration(
            DividerItemDecoration(this, RecyclerView.VERTICAL)
        )
    }

    private fun criarTimes() : List<Time>{
        return listOf(
            Time("Coritiba", "Paraná", "Segunda Divisão"),
            Time("Atlético Paranaense", "Paraná", "Primeira Divisão"),
            Time("Guarani", "São Paulo", "Segunda Divisão"),
            Time("Paraná Clube", "Paraná", "Quarta Divisão"),
            Time("Londrina", "Paraná", "Terceira Divisão"),
            Time("Flamengo", "Rio de Janeiro", "Primeira Divisão"),
        )
    }
}