package com.example.aninterface

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewActivity : AppCompatActivity() {

    private lateinit var rvLista: RecyclerView
    private lateinit var btnClique: Button
    private lateinit var mensagemAdapter: MensagemAdapter
    private lateinit var mainActivity: MainActivity
    private lateinit var cliqueActualization: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        val lista = mutableListOf(
            Mensagem("Formulario 01" ),
            Mensagem("Formulario 02" ),
            Mensagem("Formulario 03" ),
            Mensagem("Formulario 04" ),
            Mensagem("Formulario 05" ),
        )

        rvLista = findViewById(R.id.rv_lista)
        btnClique = findViewById(R.id.btn_clique)

        //tipo: MensagemAdapter, Adapter
       mensagemAdapter = MensagemAdapter { nome ->

            Toast.makeText(this, "Olá $nome", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ListViewActivity::class.java)
            intent.putExtra("nome", nome)

            startActivity(
                intent
            )
        }

        mensagemAdapter.atualizarListaDados(
            lista
        )
        rvLista.adapter = mensagemAdapter

        //LinearLayoutManager (XML e Código)
        rvLista.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        )

        cliqueActualization.setOnClickListener {

            lista.add(
                Mensagem("Nova Formulario")


            )
            mensagemAdapter.atualizarListaDados( lista )

        }

        /*rvLista.addItemDecoration(
            DividerItemDecoration(
                this,
                RecyclerView.VERTICAL
            )
        )*/

        /*rvLista.layoutManager = GridLayoutManager(
            this,
            2
        )*/
        /*rvLista.layoutManager = StaggeredGridLayoutManager(
            2,
            RecyclerView.VERTICAL
        )*/

    }
}