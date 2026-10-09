package projetoprincipiosdesign.Entrega;

public class EntregaDomicilio implements IEntrega {
    @Override
    public boolean disponivelPara(double total) {
        return true;
    }

    @Override
    public double calcularFrete(double valor) {
        return valor * 0.10;
    }
}
