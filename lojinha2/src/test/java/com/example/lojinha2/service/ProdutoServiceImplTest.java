package com.example.lojinha2.service;

import com.example.lojinha2.dto.ProdutoDTO;
import com.example.lojinha2.model.Produto;
import com.example.lojinha2.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoServiceImplTest {

    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoServiceImpl produtoService;

    private Produto produto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        produto = new Produto();
        produto.setId(1L);
        produto.setNome("Produto Teste");
        produto.setDescricao("Descrição Teste");
        produto.setQuantidadeEstoque(10);
    }

    @Test
    void listarTodos() {
        when(produtoRepository.findAll()).thenReturn(Arrays.asList(produto));

        List<ProdutoDTO> produtos = produtoService.listarTodos();

        assertEquals(1, produtos.size());
        assertEquals("Produto Teste", produtos.get(0).getNome());
    }

    @Test
    void buscarPorId() {
        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        ProdutoDTO produtoDTO = produtoService.buscarPorId(1L);

        assertNotNull(produtoDTO);
        assertEquals("Produto Teste", produtoDTO.getNome());
    }

    @Test
    void salvar() {
        when(produtoRepository.save(any(Produto.class))).thenReturn(produto);

        Produto salvo = produtoService.salvar(produto);

        assertNotNull(salvo);
        assertEquals("Produto Teste", salvo.getNome());
    }

    @Test
    void excluir() {
        doNothing().when(produtoRepository).deleteById(1L);

        produtoService.excluir(1L);

        verify(produtoRepository, times(1)).deleteById(1L);
    }
}
