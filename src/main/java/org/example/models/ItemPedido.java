package org.example.models;

public class ItemPedido {

    private Pedido pedido;
    private Produto produto;
    private int quantidade;

    public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
        this.pedido = pedido;
        this.produto = produto;

        if (produto.getQuantidade() < quantidade) {
            throw new RuntimeException("Estoque insuficiente");
        }

        this.quantidade = quantidade;

        produto.diminuirEstoque(quantidade);
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }
}