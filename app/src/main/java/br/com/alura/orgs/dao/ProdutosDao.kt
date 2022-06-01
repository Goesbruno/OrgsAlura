package br.com.alura.orgs.dao

import br.com.alura.orgs.model.Produtos

class ProdutosDao {

    fun adiciona(produto: Produtos){
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produtos>{
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produtos>()
    }

}