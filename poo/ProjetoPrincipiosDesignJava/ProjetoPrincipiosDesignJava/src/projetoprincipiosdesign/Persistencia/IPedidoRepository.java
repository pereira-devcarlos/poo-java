package projetoprincipiosdesign.Persistencia;

import projetoprincipiosdesign.Dominio.Pedido;

public interface IPedidoRepository {
    void salvar(Pedido pedido, double total);
}
