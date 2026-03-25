package org.example.models;

public class Pagamento {

    private int id;
    private double valor;
    private String status;
    private Pedido pedido;

    public Pagamento(int id, double valor, Pedido pedido) {
        this.id = id;
        this.valor = valor;
        this.pedido = pedido;
        this.status = "PENDENTE";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public double getValor() {
        return valor;
    }

    public Pedido getPedido() {
        return pedido;
    }
}