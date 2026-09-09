package projetoprincipiosdesign.Persistencia;

import projetoprincipiosdesign.Dominio.Pedido;

public class PedidoRepositoryBanco implements PedidoRepository {
    @Override
    public void salvar(Pedido pedido, double total) {
        // Implementação para salvar o pedido no banco de dados
        System.out.println("Pedido salvo no banco de dados: " + pedido);
    }
    
}
