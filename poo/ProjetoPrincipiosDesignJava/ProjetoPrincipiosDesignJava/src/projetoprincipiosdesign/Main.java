package projetoprincipiosdesign;

import java.util.List;

import projetoprincipiosdesign.Dominio.Cidade;
import projetoprincipiosdesign.Dominio.Cliente;
import projetoprincipiosdesign.Dominio.Endereco;
import projetoprincipiosdesign.Dominio.ItemPedido;
import projetoprincipiosdesign.Dominio.Pedido;
import projetoprincipiosdesign.Enum.TipoCliente;
import projetoprincipiosdesign.Desconto.IDesconto;
import projetoprincipiosdesign.Desconto.DescontoAluno;
import projetoprincipiosdesign.Desconto.DescontoFuncionario;
import projetoprincipiosdesign.Desconto.DescontoProfessor;
import projetoprincipiosdesign.Pagamento.PagamentoBoleto;
import projetoprincipiosdesign.Pagamento.PagamentoCartao;
import projetoprincipiosdesign.Pagamento.PagamentoPix;
import projetoprincipiosdesign.Persistencia.IPedidoRepository;
import projetoprincipiosdesign.Persistencia.PedidoRepositoryArquivo;

public class Main {
    public static void main(String[] args) {
        System.out.println("================ LOJA ACADÊMICA ================");

        Cliente clienteAluno = new Cliente(
            "Ana",
            new Endereco(
                "Rua das Flores",
                new Cidade("Belo Horizonte")
            ),
            TipoCliente.ALUNO
        );

        Cliente clienteProfessor = new Cliente(
            "Carlos",
            new Endereco(
                "Avenida Central",
                new Cidade("São Paulo")
            ),
            TipoCliente.PROFESSOR
        );

        Cliente clienteFuncionario = new Cliente(
            "Mariana",
            new Endereco(
                "Rua do Comércio",
                new Cidade("Rio de Janeiro")
            ),
            TipoCliente.FUNCIONARIO
        );

        Pedido pedido1 = new Pedido(
            clienteAluno,
            List.of(
                new ItemPedido("Livro de Engenharia de Software", 120.0, 1),
                new ItemPedido("Caderno", 20.0, 2)
            )
        );

        Pedido pedido2 = new Pedido(
            clienteProfessor,
            List.of(
                new ItemPedido("Livro de Matemática", 80.0, 1),
                new ItemPedido("Caneta", 5.0, 3)
            )
        );

        Pedido pedido3 = new Pedido(
            clienteFuncionario,
            List.of(
                new ItemPedido("Livro de Administração", 100.0, 1),
                new ItemPedido("Agenda", 30.0, 1)
            )
        );

        IPedidoRepository repository = new PedidoRepositoryArquivo();
        PedidoService servico = new PedidoService(repository);

        System.out.println();
        System.out.println("=================== PEDIDO 1 ===================");
        System.out.print("Cidade de entrega: ");
        System.out.println(clienteAluno.getCidadeEntrega());

        System.out.println("------------------------------------------------");
        System.out.println("Pedido:");
        servico.finalizarPedido(pedido1, descontoPara(clienteAluno), new PagamentoBoleto());

        System.out.println();
        System.out.println("=================== PEDIDO 2 ===================");
        System.out.print("Cidade de entrega: ");
        System.out.println(clienteProfessor.getCidadeEntrega());

        System.out.println("------------------------------------------------");
        System.out.println("Pedido:");
        servico.finalizarPedido(pedido2, descontoPara(clienteProfessor), new PagamentoCartao(3));

        System.out.println();
        System.out.println("=================== PEDIDO 3 ===================");
        System.out.print("Cidade de entrega: ");
        System.out.println(clienteFuncionario.getCidadeEntrega());

        System.out.println("------------------------------------------------");
        System.out.println("Pedido:");
        servico.finalizarPedido(pedido3, descontoPara(clienteFuncionario), new PagamentoPix());

        System.out.println();
        System.out.println("Programa executado com sucesso.");
    }

    private static IDesconto descontoPara(Cliente cliente) {
        return switch (cliente.getTipoCliente()) {
            case ALUNO -> new DescontoAluno();
            case PROFESSOR -> new DescontoProfessor();
            case FUNCIONARIO -> new DescontoFuncionario();
        };
    }
}
