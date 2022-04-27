package br.com.calculadoraaposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.*

class MainActivity : Activity(){

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)

        // define o conteúdo da tela - arquivo de layout
        setContentView(R.layout.activity_main)

        // cria as variáveis para acessar os componentes do script xml
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)
        val txt_idade = findViewById<EditText>(R.id.txt_idade)
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        // cria as opções do Spinner para a escolha do sexo
        spn_sexo.adapter = ArrayAdapter<String> (this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino", "Feminino"))

        // quando o botão "calcular" do app for acionado, o método abaixo será acionado
        btn_calcular.setOnClickListener {

            // Tranforma o Editable (gerado pelo metodo text) em Str e então em Int
            val idade = txt_idade.text.toString().toInt()

            // Tranforma um Editable (gerado pelo método selectedItem) em Str
            val sexo = spn_sexo.selectedItem as String

            var resultado = 0
            if (sexo == "Masculino")
            {
                resultado = 65 - idade
            }
            else
            {
                resultado = 60 - idade
            }

            txt_resultado.text = "Faltam $resultado anos para sua aposentadoria"

        }


    }
}