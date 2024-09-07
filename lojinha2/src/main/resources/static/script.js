document.addEventListener('DOMContentLoaded', function() {
    carregarFornecedores();
    carregarProdutos();
});

// Funções para Fornecedores

async function carregarFornecedores() {
    const response = await fetch('/api/fornecedores');
    const fornecedores = await response.json();
    const lista = document.getElementById('fornecedores');
    const selectFornecedores = document.getElementById('fornecedorProduto');

    lista.innerHTML = '';
    selectFornecedores.innerHTML = '<option value="">Selecione um fornecedor</option>';

    fornecedores.forEach(fornecedor => {
        const item = document.createElement('li');
        item.textContent = `Nome: ${fornecedor.nome}, Contato: ${fornecedor.contato}`;
        
        // Botão de deletar fornecedor
        const btnDeletar = document.createElement('button');
        btnDeletar.textContent = 'Deletar';
        btnDeletar.onclick = async () => {
            await fetch(`/api/fornecedores/${fornecedor.id}`, { method: 'DELETE' });
            carregarFornecedores();
            carregarProdutos(); // Recarrega produtos, pois um produto pode estar ligado ao fornecedor deletado
        };

        item.appendChild(btnDeletar);
        lista.appendChild(item);

        const option = document.createElement('option');
        option.value = fornecedor.id;
        option.textContent = fornecedor.nome;
        selectFornecedores.appendChild(option);
    });
}

document.getElementById('fornecedorForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const nome = document.getElementById('nomeFornecedor').value;
    const contato = document.getElementById('contatoFornecedor').value;

    const fornecedor = {
        nome,
        contato
    };

    await fetch('/api/fornecedores', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(fornecedor)
    });

    carregarFornecedores();
    document.getElementById('fornecedorForm').reset();
});

document.getElementById('buscarFornecedorForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const id = document.getElementById('idFornecedorBusca').value;

    const response = await fetch(`/api/fornecedores/${id}`);
    const fornecedor = await response.json();

    const resultado = document.getElementById('resultadoFornecedor');
    if (fornecedor.nome) {
        resultado.textContent = `Nome: ${fornecedor.nome}, Contato: ${fornecedor.contato}`;
    } else {
        resultado.textContent = 'Fornecedor não encontrado';
    }
});

// Funções para Produtos

async function carregarProdutos() {
    const response = await fetch('/api/produtos');
    const produtos = await response.json();
    const lista = document.getElementById('produtos');

    lista.innerHTML = '';

    produtos.forEach(produto => {
        const item = document.createElement('li');
        item.textContent = `Nome: ${produto.nome}, Descrição: ${produto.descricao}, Quantidade: ${produto.quantidadeEstoque}, Fornecedor: ${produto.fornecedorNome}`;
        
        // Botão de deletar produto
        const btnDeletar = document.createElement('button');
        btnDeletar.textContent = 'Deletar';
        btnDeletar.onclick = async () => {
            await fetch(`/api/produtos/${produto.id}`, { method: 'DELETE' });
            carregarProdutos();
        };

        item.appendChild(btnDeletar);
        lista.appendChild(item);
    });
}

document.getElementById('produtoForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const nome = document.getElementById('nomeProduto').value;
    const descricao = document.getElementById('descricaoProduto').value;
    const quantidadeEstoque = document.getElementById('quantidadeProduto').value;
    const fornecedorId = document.getElementById('fornecedorProduto').value;

    const produto = {
        nome,
        descricao,
        quantidadeEstoque,
        fornecedor: { id: fornecedorId }
    };

    await fetch('/api/produtos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(produto)
    });

    carregarProdutos();
    document.getElementById('produtoForm').reset();
});

document.getElementById('buscarProdutoForm').addEventListener('submit', async function(event) {
    event.preventDefault();

    const id = document.getElementById('idProdutoBusca').value;

    const response = await fetch(`/api/produtos/${id}`);
    const produto = await response.json();

    const resultado = document.getElementById('resultadoProduto');
    if (produto.nome) {
        resultado.textContent = `Nome: ${produto.nome}, Descrição: ${produto.descricao}, Quantidade: ${produto.quantidadeEstoque}, Fornecedor: ${produto.fornecedorNome}`;
    } else {
        resultado.textContent = 'Produto não encontrado';
    }
});
