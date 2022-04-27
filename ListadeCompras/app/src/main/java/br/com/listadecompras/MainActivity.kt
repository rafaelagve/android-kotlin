package br.com.listadecompras

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        val list_view_produtos = findViewById<ListView>(R.id.list_view_produtos)
        val btn_inserir = findViewById<Button>(R.id.btn_button)
        val txt_produto = findViewById<EditText>(R.id.txt_produto)

        list_view_produtos.adapter = produtosAdapter // criando adaptador para ListView

        btn_inserir.setOnClickListener(){

            val produto = txt_produto.text.toString()

            if (produto.isNotEmpty()) {
                produtosAdapter.add(produto)
                txt_produto.text.clear()
            }
            else
            {
                txt_produto.error = "Preencha um valor"
            }
        } // fim do botao inserir

        list_view_produtos.setOnItemLongClickListener {
                adapterView : AdapterView<*>,
                view : View,
                position : Int,
                id : Long ->
            val item = produtosAdapter.getItem(position)  // o indice é dado por position
            produtosAdapter.remove(item)
            true // se ocorreu a remoção, true
        }

    }

}