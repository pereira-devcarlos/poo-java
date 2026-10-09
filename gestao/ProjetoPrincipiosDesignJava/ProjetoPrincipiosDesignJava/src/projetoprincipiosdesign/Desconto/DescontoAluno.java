package projetoprincipiosdesign.Desconto;

public class DescontoAluno implements IDesconto {
    @Override
    public double aplicar(double valor) {
        return valor * 0.90;
    }
}
