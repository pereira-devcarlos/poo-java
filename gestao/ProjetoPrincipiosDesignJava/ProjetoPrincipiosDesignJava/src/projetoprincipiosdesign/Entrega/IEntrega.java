package projetoprincipiosdesign.Entrega;

public interface IEntrega {
    boolean disponivelPara(double total);
    double calcularFrete(double total);
}
