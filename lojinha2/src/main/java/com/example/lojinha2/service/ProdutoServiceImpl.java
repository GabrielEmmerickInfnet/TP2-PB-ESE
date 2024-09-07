package com.example.lojinha2.service;

import com.example.lojinha2.dto.ProdutoDTO;
import com.example.lojinha2.model.Produto;
import com.example.lojinha2.repository.ProdutoRepository;
import com.example.lojinha2.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll().stream()
            .map(ProdutoDTO::new)
            .collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO buscarPorId(Long id) {
        return produtoRepository.findById(id)
            .map(ProdutoDTO::new)
            .orElse(null);
    }

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }
}
