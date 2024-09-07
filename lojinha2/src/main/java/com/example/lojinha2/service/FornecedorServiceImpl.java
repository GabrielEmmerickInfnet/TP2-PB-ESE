package com.example.lojinha2.service;

import com.example.lojinha2.dto.FornecedorDTO;
import com.example.lojinha2.model.Fornecedor;
import com.example.lojinha2.repository.FornecedorRepository;
import com.example.lojinha2.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorServiceImpl(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public List<FornecedorDTO> listarTodos() {
        return fornecedorRepository.findAll().stream()
            .map(FornecedorDTO::new)
            .collect(Collectors.toList());
    }

    @Override
    public FornecedorDTO buscarPorId(Long id) {
        return fornecedorRepository.findById(id)
            .map(FornecedorDTO::new)
            .orElse(null);
    }

    @Override
    public Fornecedor salvar(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    @Override
    public void excluir(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
