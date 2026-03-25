import org.example.models.*;
import org.example.service.LojaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LojaService loja = new LojaService();
        Scanner sc = new Scanner(System.in);

        Cliente cliente = loja.buscarCliente(1);

        Pedido pedido = loja.criarPedido(cliente);

        while (true) {
            System.out.println("\nProdutos disponíveis:");

            for (Produto p : loja.listarProdutos()) {
                System.out.println(
                        p.getId() + " - " + p.getNome() +
                                " R$" + p.getPreco() +
                                " (Estoque: " + p.getQuantidade() + ")"
                );
            }

            System.out.print("\nDigite o ID do produto (0 para finalizar): ");
            int idProduto = sc.nextInt();

            if (idProduto == 0) break;

            Produto produto = loja.buscarProduto(idProduto);

            if (produto == null) {
                System.out.println("Produto inválido!");
                continue;
            }

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();

            try {
                ItemPedido item = new ItemPedido(pedido, produto, quantidade);

                pedido.adicionarItem(produto, quantidade);

                System.out.println("Item adicionado!");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        boolean pago = loja.finalizarPedido(pedido);

        System.out.println("\nTotal do pedido: R$ " + pedido.calcularTotal());

        if (pago) {
            System.out.println("Pagamento aprovado");
        } else {
            System.out.println("Pagamento recusado");
        }

        sc.close();
    }
}