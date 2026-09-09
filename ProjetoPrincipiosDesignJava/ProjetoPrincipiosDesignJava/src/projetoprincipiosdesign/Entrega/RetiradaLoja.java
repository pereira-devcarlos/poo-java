package projetoprincipiosdesign.Entrega;

public class RetiradaLoja implements TipoEntrega {
    @Override
    public void calcularFrete(double valor) {
        double frete = 0.0; // Sem frete para retirada na loja
        double valorComFrete = valor + frete;
        System.out.println("Valor original: " + valor);
        System.out.println("Frete aplicado: " + frete);
        System.out.println("Valor com frete: " + valorComFrete);
    }
    
}
