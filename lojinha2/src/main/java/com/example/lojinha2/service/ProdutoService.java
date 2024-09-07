package com.example.lojinha2.service;

import com.example.lojinha2.dto.ProdutoDTO;
import com.example.lojinha2.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    List<ProdutoDTO> listarTodos();

    ProdutoDTO buscarPorId(Long id);

    Produto salvar(Produto produto);

    void excluir(Long id);
}
