package projetoprincipiosdesign.Persistencia;

import projetoprincipiosdesign.Dominio.Pedido;

public interface PedidoRepository {
    void salvar(Pedido pedido, double total);
}
