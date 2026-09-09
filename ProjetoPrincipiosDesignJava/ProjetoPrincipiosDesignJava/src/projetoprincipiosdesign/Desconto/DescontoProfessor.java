package projetoprincipiosdesign.Desconto;

public class DescontoProfessor implements Desconto {
    @Override
    public double calcularDesconto(double valor) {
        double desconto = valor * 0.15; // 15% de desconto para professores
        double valorComDesconto = valor - desconto;
        System.out.println("Valor original: " + valor);
        System.out.println("Desconto aplicado: " + desconto);
        System.out.println("Valor com desconto: " + valorComDesconto);
        return valorComDesconto;
    }
    
}
