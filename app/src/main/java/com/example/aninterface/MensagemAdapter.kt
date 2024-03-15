package com.example.aninterface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MensagemAdapter(
    private val clique: (String) -> Unit
) : Adapter<MensagemAdapter.MensagemViewHolder>() {

    private var listaMensagens = mutableListOf<Mensagem>()

    fun executarOperacao(){
        listaMensagens.add(
            Mensagem("Renilson")
        )
        notifyItemInserted(listaMensagens.size)
    }

    fun atualizarListaDados( lista: MutableList<Mensagem> ){
        //listaMensagens.addAll( lista )
        listaMensagens = lista
        notifyDataSetChanged()
    }

    inner class MensagemViewHolder(
        val itemView: View
    ) : ViewHolder( itemView )  {

        /*val textNome: TextView = itemView.findViewById(R.id.text_nome)
        val textUltima: TextView = itemView.findViewById(R.id.text_ultima)*/

        val textForm: TextView = itemView.findViewById(R.id.txt_Form)
        val txtAmount: TextView= itemView.findViewById(R.id.textAmount)
        val textAplica: TextView = itemView.findViewById(R.id.text_Aplicacao)
        val txtVisualizacao: TextView = itemView.findViewById(R.id.txt_Visualização)
        val txtTransmissao: TextView = itemView.findViewById(R.id.txt_Transmi)

        //val textHorario: TextView = itemView.findViewById(R.id.text_horario)
        //val txtTransmi: ImageView = itemView.findViewById(R.id.txt_Transmi)
        fun bind( mensagem: Mensagem){//Conectar com a interface

            textForm.text = mensagem.nome
            //textAplica.text = mensagem.ultima

            //Aplicar eventos de clique
            //val context = cardView.context
           /* btnClique.setOnClickListener {
                clique( mensagem.nome )
            }*/
        }

    }

    //Ao Criar o View Holder -> Criar a visualização
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensagemViewHolder {

        val layoutInflater = LayoutInflater.from(
            parent.context
        )

        /*val itemView = layoutInflater.inflate(
            R.layout.item_lista, parent, false
        )*/

        val itemView = layoutInflater.inflate(
            R.layout.item_cardview, parent, false
        )

        return MensagemViewHolder( itemView )

    }

    // ao vincular os dados para a visualização
    override fun onBindViewHolder(holder: MensagemViewHolder, position: Int) {
        val mensagem = listaMensagens[position]
        holder.bind( mensagem )
    }

    //getItemCount -> Recuperar a quantidade de itens
    override fun getItemCount(): Int {
        return listaMensagens.size
    }

}