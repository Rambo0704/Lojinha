package org.example.external;

public class PagamentoGateway {

    private static PagamentoGateway instancia;

    private PagamentoGateway() {}

    public static PagamentoGateway getInstancia() {
        if (instancia == null) {
            instancia = new PagamentoGateway();
        }
        return instancia;
    }

    public boolean processarPagamento(double valor) {
        System.out.println("Pagamento de R$ " + valor + " processado.");
        return true;
    }
}
