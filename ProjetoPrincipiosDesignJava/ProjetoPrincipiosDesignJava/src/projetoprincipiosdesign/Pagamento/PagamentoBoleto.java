package projetoprincipiosdesign.Pagamento;

public class PagamentoBoleto implements Pagamento, GerarBoleto {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via Boleto no valor de: " + valor);
    }

    @Override
    public void gerarBoleto(double valor) {
        System.out.println("Geração de boleto no valor de: " + valor);
    }
    
}
