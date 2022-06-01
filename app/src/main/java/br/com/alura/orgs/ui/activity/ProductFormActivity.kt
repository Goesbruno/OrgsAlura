package br.com.alura.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutosDao
import br.com.alura.orgs.model.Produtos
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity(R.layout.activity_product_form) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configuraBotaoSalvar()

    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.button_save)
        val dao = ProdutosDao()
        botaoSalvar.setOnClickListener {
            val produtoNovo = produtos()

            Log.i("ProductFormActivity", "onCreate: $produtoNovo")

            dao.adiciona(produtoNovo)
            Log.i("ProductFormActivity", "onCreate: ${dao.buscaTodos()}")
            finish()
        }
    }

    private fun produtos(): Produtos {
        val campoNome = findViewById<EditText>(R.id.form_item_nome)
        val nome = campoNome.text.toString()
        val campoDescricao = findViewById<EditText>(R.id.form_item_descricao)
        val descricao = campoDescricao.text.toString()
        val campoValor = findViewById<EditText>(R.id.form_item_valor)
        val valorEmTexto = campoValor.text.toString()
        val valor = if (valorEmTexto.isBlank()) {
            BigDecimal.ZERO
        } else {
            valorEmTexto.toBigDecimal()
        }

        return Produtos(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }

}