package com.example.lojinha2.service;

import com.example.lojinha2.dto.FornecedorDTO;
import com.example.lojinha2.model.Fornecedor;
import com.example.lojinha2.repository.FornecedorRepository;
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

class FornecedorServiceImplTest {

    @Mock
    private FornecedorRepository fornecedorRepository;

    @InjectMocks
    private FornecedorServiceImpl fornecedorService;

    private Fornecedor fornecedor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        fornecedor = new Fornecedor();
        fornecedor.setId(1L);
        fornecedor.setNome("Fornecedor Teste");
        fornecedor.setContato("Contato Teste");
    }

    @Test
    void listarTodos() {
        when(fornecedorRepository.findAll()).thenReturn(Arrays.asList(fornecedor));

        List<FornecedorDTO> fornecedores = fornecedorService.listarTodos();

        assertEquals(1, fornecedores.size());
        assertEquals("Fornecedor Teste", fornecedores.get(0).getNome());
    }

    @Test
    void buscarPorId() {
        when(fornecedorRepository.findById(1L)).thenReturn(Optional.of(fornecedor));

        FornecedorDTO fornecedorDTO = fornecedorService.buscarPorId(1L);

        assertNotNull(fornecedorDTO);
        assertEquals("Fornecedor Teste", fornecedorDTO.getNome());
    }

    @Test
    void salvar() {
        when(fornecedorRepository.save(any(Fornecedor.class))).thenReturn(fornecedor);

        Fornecedor salvo = fornecedorService.salvar(fornecedor);

        assertNotNull(salvo);
        assertEquals("Fornecedor Teste", salvo.getNome());
    }

    @Test
    void excluir() {
        doNothing().when(fornecedorRepository).deleteById(1L);

        fornecedorService.excluir(1L);

        verify(fornecedorRepository, times(1)).deleteById(1L);
    }
}
