package projetoprincipiosdesign;

import java.util.List;

import projetoprincipiosdesign.Dominio.Cidade;
import projetoprincipiosdesign.Dominio.Cliente;
import projetoprincipiosdesign.Dominio.Endereco;
import projetoprincipiosdesign.Dominio.ItemPedido;
import projetoprincipiosdesign.Dominio.Pedido;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== LOJA ACADÊMICA ===");

        Cliente cliente = new Cliente(
            "Ana",
            new Endereco(
                "Rua das Flores",
                new Cidade("Belo Horizonte")
            )
        );

        Pedido pedido = new Pedido(
            cliente,
            List.of(
                new ItemPedido("Livro de Engenharia de Software", 120.0, 1),
                new ItemPedido("Caderno", 20.0, 2)
            )
        );

        PedidoService servico = new PedidoService();

        System.out.println();
        System.out.println("Cidade de entrega:");
        System.out.println(servico.obterCidadeEntrega(pedido));

        System.out.println();
        System.out.println("Total com desconto:");
        System.out.printf("R$ %.2f%n", servico.calcularTotal(pedido, "ALUNO"));

        System.out.println();
        System.out.println("Pagamento:");
        servico.finalizarPedido(pedido, "CARTAO", "ALUNO", 3);

        System.out.println();
        System.out.println("Programa executado com sucesso.");
    }
}
