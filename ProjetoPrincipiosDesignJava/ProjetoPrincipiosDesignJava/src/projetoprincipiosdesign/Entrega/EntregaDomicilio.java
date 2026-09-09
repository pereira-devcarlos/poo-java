package projetoprincipiosdesign.Entrega;

public class EntregaDomicilio implements TipoEntrega {
    @Override
    public void calcularFrete(double valor) {
        double frete = valor * 0.10; // 10% de frete para entrega domiciliar
        double valorComFrete = valor + frete;
        System.out.println("Valor original: " + valor);
        System.out.println("Frete aplicado: " + frete);
        System.out.println("Valor com frete: " + valorComFrete);
    }
    
}
