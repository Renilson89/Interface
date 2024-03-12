package com.example.aninterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.aninterface.R

class ListViewActivity : AppCompatActivity() {

    private lateinit var listViewUsuarios: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listaUsuarios = listOf(
            "1", "2", "3", "4", "5"
        )

        listViewUsuarios = findViewById(R.id.list_usuarios)
        listViewUsuarios.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            listaUsuarios
        )


    }
}