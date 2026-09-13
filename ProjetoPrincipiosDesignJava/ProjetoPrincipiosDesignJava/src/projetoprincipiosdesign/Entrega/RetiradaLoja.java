package projetoprincipiosdesign.Entrega;

public class RetiradaLoja implements IEntrega {
    @Override
    public boolean disponivelPara(double total) {
        return total >= 50.0;
    }

    @Override
    public double calcularFrete(double valor) {
        return 0.0;
    }
}
