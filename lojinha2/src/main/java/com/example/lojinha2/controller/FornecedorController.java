package com.example.lojinha2.controller;

import com.example.lojinha2.dto.FornecedorDTO;
import com.example.lojinha2.model.Fornecedor;
import com.example.lojinha2.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<FornecedorDTO> listarTodos() {
        return fornecedorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorDTO> buscarPorId(@PathVariable Long id) {
        FornecedorDTO fornecedor = fornecedorService.buscarPorId(id);
        return fornecedor != null ? ResponseEntity.ok(fornecedor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Fornecedor adicionarFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.salvar(fornecedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFornecedor(@PathVariable Long id) {
        fornecedorService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
