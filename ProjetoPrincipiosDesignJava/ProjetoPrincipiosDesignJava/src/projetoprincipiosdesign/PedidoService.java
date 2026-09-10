package projetoprincipiosdesign;

import projetoprincipiosdesign.Desconto.Desconto;
import projetoprincipiosdesign.Desconto.DescontoAluno;
import projetoprincipiosdesign.Desconto.DescontoFuncionario;
import projetoprincipiosdesign.Desconto.DescontoProfessor;
import projetoprincipiosdesign.Dominio.ItemPedido;
import projetoprincipiosdesign.Dominio.Pedido;
import projetoprincipiosdesign.Enum.FormaPagamento;
import projetoprincipiosdesign.Enum.TipoCliente;
import projetoprincipiosdesign.Pagamento.PagamentoService;
import projetoprincipiosdesign.Persistencia.PedidoRepository;
import projetoprincipiosdesign.Persistencia.PedidoRepositoryArquivo;

public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final PagamentoService pagamentoService;

    public PedidoService(PagamentoService pagamentoService) {
        this.pedidoRepository = new PedidoRepositoryArquivo();
        this.pagamentoService = pagamentoService;
    }

    public double calcularTotal(Pedido pedido) {
        double total = 0.0;

        // Calcular o total do pedido com base nos itens
        for (ItemPedido item : pedido.getItens()) {
            total += item.getPreco() * item.getQuantidade();
        }

        // Aplicar desconto com base no tipo de cliente
        Desconto desconto = criarDesconto(pedido.getCliente().getTipoCliente());
        total = desconto.calcularDesconto(total);
        return total;
    }

    public void finalizarPedido(Pedido pedido, FormaPagamento formaPagamento, int numeroParcelas) {
        double total = calcularTotal(pedido);

        pedidoRepository.salvar(pedido, total);
        pagamentoService.processarPagamento(formaPagamento, total, numeroParcelas);

        System.out.println("------------------------------------------------");
        System.out.println(
            "Enviando mensagem para " + pedido.getCliente().getNome() + ": pedido finalizado."
        );
    }

    // Metodo privado para criar o objeto de desconto com base no tipo de cliente
    private Desconto criarDesconto(TipoCliente tipoCliente) {
        return switch (tipoCliente) {
            case ALUNO -> new DescontoAluno();
            case PROFESSOR -> new DescontoProfessor();
            case FUNCIONARIO -> new DescontoFuncionario();

            default -> throw new IllegalArgumentException(
                "Tipo de cliente inválido: " + tipoCliente
            );
        };
    }
}
