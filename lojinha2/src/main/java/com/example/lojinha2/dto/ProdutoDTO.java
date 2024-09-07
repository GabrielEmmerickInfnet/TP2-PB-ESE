package com.example.lojinha2.dto;

import com.example.lojinha2.model.Produto;

public class ProdutoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Integer quantidadeEstoque;
    private Double preco;
    private String fornecedorNome;

    public ProdutoDTO(Long id, String nome, String descricao, Integer quantidadeEstoque, Double preco, String fornecedorNome) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
        this.preco = preco;
        this.fornecedorNome = fornecedorNome;
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.quantidadeEstoque = produto.getQuantidadeEstoque();
        this.preco = produto.getPreco();
        this.fornecedorNome = produto.getFornecedor() != null ? produto.getFornecedor().getNome() : null;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getFornecedorNome() {
		return fornecedorNome;
	}

	public void setFornecedorNome(String fornecedorNome) {
		this.fornecedorNome = fornecedorNome;
	}

    // Getters e Setters
    
    
}
