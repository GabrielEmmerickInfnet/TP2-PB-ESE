package com.example.lojinha2.service;

import com.example.lojinha2.dto.FornecedorDTO;
import com.example.lojinha2.model.Fornecedor;

import java.util.List;
import java.util.Optional;

public interface FornecedorService {

    List<FornecedorDTO> listarTodos();

    FornecedorDTO buscarPorId(Long id);

    Fornecedor salvar(Fornecedor fornecedor);

    void excluir(Long id);
}
