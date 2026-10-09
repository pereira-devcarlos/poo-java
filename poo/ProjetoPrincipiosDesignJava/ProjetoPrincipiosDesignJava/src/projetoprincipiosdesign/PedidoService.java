package projetoprincipiosdesign;

import projetoprincipiosdesign.Desconto.IDesconto;
import projetoprincipiosdesign.Dominio.ItemPedido;
import projetoprincipiosdesign.Dominio.Pedido;
import projetoprincipiosdesign.Pagamento.IPagamento;
import projetoprincipiosdesign.Persistencia.IPedidoRepository;

public class PedidoService {
    private final IPedidoRepository repository;

    public PedidoService(IPedidoRepository repository) {
        this.repository = repository;
    }

    public double calcularTotal(Pedido pedido, IDesconto desconto) {
        double total = 0.0;

        for (ItemPedido item : pedido.getItens()) {
            total += item.getPreco() * item.getQuantidade();
        }

        return desconto.aplicar(total);
    }

    public void finalizarPedido(Pedido pedido, IDesconto desconto, IPagamento pagamento) {
        double total = calcularTotal(pedido, desconto);

        repository.salvar(pedido, total);
        pagamento.processar(total);

        System.out.println("------------------------------------------------");
        System.out.println(
            "Enviando mensagem para " + pedido.getCliente().getNome() + ": pedido finalizado."
        );
    }
}
