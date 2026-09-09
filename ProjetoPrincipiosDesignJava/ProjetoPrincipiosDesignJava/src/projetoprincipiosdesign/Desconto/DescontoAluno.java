package projetoprincipiosdesign.Desconto;

public class DescontoAluno implements Desconto {
    @Override
    public double calcularDesconto(double valor) {
        double desconto = valor * 0.1; // 10% de desconto para alunos
        double valorComDesconto = valor - desconto;
        System.out.println("Valor original: " + valor);
        System.out.println("10% de desconto aplicado: " + desconto);
        System.out.println("Valor com desconto: " + valorComDesconto);
        return valorComDesconto;
    }
    
}
