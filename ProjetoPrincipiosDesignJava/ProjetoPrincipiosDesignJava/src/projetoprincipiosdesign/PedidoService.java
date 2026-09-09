package projetoprincipiosdesign;

import projetoprincipiosdesign.Desconto.Desconto;
import projetoprincipiosdesign.Desconto.DescontoAluno;
import projetoprincipiosdesign.Desconto.DescontoFuncionario;
import projetoprincipiosdesign.Desconto.DescontoProfessor;
import projetoprincipiosdesign.Dominio.ItemPedido;
import projetoprincipiosdesign.Dominio.Pedido;
import projetoprincipiosdesign.Pagamento.Pagamento;
import projetoprincipiosdesign.Pagamento.PagamentoBoleto;
import projetoprincipiosdesign.Pagamento.PagamentoCartao;
import projetoprincipiosdesign.Pagamento.PagamentoPix;
import projetoprincipiosdesign.Persistencia.PedidoRepositoryArquivo;

public class PedidoService {
    private PedidoRepositoryArquivo pedidoRepository;

    public PedidoService() {
        this.pedidoRepository = new PedidoRepositoryArquivo();
    }

    public double calcularTotal(Pedido pedido, String tipoCliente) {
        double total = 0.0;

        for (ItemPedido item : pedido.getItens()) {
            total += item.getPreco() * item.getQuantidade();
        }

        Desconto desconto = criarDesconto(tipoCliente);
        total = desconto.calcularDesconto(total);

        return total;
    }

    public String obterCidadeEntrega(Pedido pedido) {
        return pedido.getCliente().getEndereco().getCidade().getNome();
    }

    public void finalizarPedido(Pedido pedido, String formaPagamento, String tipoCliente, int numeroParcelas) {
        double total = calcularTotal(pedido, tipoCliente);

        pedidoRepository.salvar(pedido, total);

        System.out.println("Gerando resumo do pedido...");
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.printf("Total: R$ %.2f%n", total);

        Pagamento pagamento = criarPagamento(formaPagamento);
        pagamento.pagar(total);

        System.out.println(
            "Enviando mensagem para " + pedido.getCliente().getNome() + ": pedido finalizado."
        );
    }

    private Pagamento criarPagamento(String formaPagamento) {
        return switch (formaPagamento) {
            case "CARTAO" -> new PagamentoCartao();
            case "PIX" -> new PagamentoPix();
            case "BOLETO" -> new PagamentoBoleto();

            default -> throw new IllegalArgumentException(
                "Forma de pagamento inválida: " + formaPagamento
            );
        };
    }

    private Desconto criarDesconto(String tipoCliente) {
        return switch (tipoCliente) {
            case "ALUNO" -> new DescontoAluno();
            case "PROFESSOR" -> new DescontoProfessor();
            case "FUNCIONARIO" -> new DescontoFuncionario();

            default -> throw new IllegalArgumentException(
                "Tipo de cliente inválido: " + tipoCliente
            );
        };
    }
}
