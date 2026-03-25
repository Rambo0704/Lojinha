package org.example.service;

import org.example.models.*;
import org.example.external.PagamentoGateway;

import java.util.ArrayList;
import java.util.List;

public class LojaService {

    private List<Cliente> clientes = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private int contadorPedido = 1;

    public LojaService() {
        // Clientes estáticos
        clientes.add(new Cliente(1, "Gabriel"));
        clientes.add(new Cliente(2, "Ana"));

        // Produtos
        produtos.add(new Produto(1, "Notebook", 3000, 10));
        produtos.add(new Produto(2, "Mouse", 100, 50));
        produtos.add(new Produto(3, "Teclado", 200, 30));
    }

    public Cliente buscarCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto buscarProduto(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public Pedido criarPedido(Cliente cliente) {
        return new Pedido(contadorPedido++, cliente);
    }

    public boolean finalizarPedido(Pedido pedido) {

        double total = pedido.calcularTotal();

        Pagamento pagamento = new Pagamento(1, total, pedido);

        PagamentoGateway gateway = PagamentoGateway.getInstancia();
        boolean aprovado = gateway.processarPagamento(total);

        if (aprovado) {
            pagamento.setStatus("PAGO");
        } else {
            pagamento.setStatus("RECUSADO");
        }

        return aprovado;
    }
}