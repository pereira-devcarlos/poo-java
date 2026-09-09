package projetoprincipiosdesign.Desconto;

public class DescontoFuncionario implements Desconto {
    @Override
    public double calcularDesconto(double valor) {
        double desconto = valor * 0.2; // 20% de desconto para funcionários
        double valorComDesconto = valor - desconto;
        System.out.println("Valor original: " + valor);
        System.out.println("20% de desconto aplicado: " + desconto);
        System.out.println("Valor com desconto: " + valorComDesconto);
        return valorComDesconto;
    }
    
}
