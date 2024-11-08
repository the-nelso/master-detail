package com.example.masterdetail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    private var time: Time? = null;
    private lateinit var imageView: ImageView;
    private lateinit var nomeTextView: TextView;
    private lateinit var estadoTextView: TextView;
    private lateinit var divisaoTextView: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        imageView = findViewById(R.id.imageView);
        nomeTextView = findViewById(R.id.nomeTextView);
        estadoTextView = findViewById(R.id.estadoTextView);
        divisaoTextView = findViewById(R.id.divisaoTextView);

        time = intent.getSerializableExtra("time") as Time;

        if(time != null){
            imageView.setImageResource(time!!.imagem);
            nomeTextView.text = time!!.nome;
            estadoTextView.text = time!!.estado;
            divisaoTextView.text = time!!.divisao;
        }
    }


}