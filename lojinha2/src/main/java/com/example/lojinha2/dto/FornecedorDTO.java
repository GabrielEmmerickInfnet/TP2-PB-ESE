package com.example.lojinha2.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.lojinha2.model.Fornecedor;
import com.example.lojinha2.model.Produto;

public class FornecedorDTO {

    private Long id;
    private String nome;
    private String contato;
    private List<String> produtos;

    public FornecedorDTO(Long id, String nome, String contato, List<String> produtos) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
        this.produtos = produtos;
    }

    public FornecedorDTO(Fornecedor fornecedor) {
        this.id = fornecedor.getId();
        this.nome = fornecedor.getNome();
        this.contato = fornecedor.getContato();
        this.produtos = fornecedor.getProdutos().stream()
            .map(Produto::getNome)
            .collect(Collectors.toList());
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

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public List<String> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<String> produtos) {
		this.produtos = produtos;
	}

    // Getters e Setters
    
    
}
