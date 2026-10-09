package projetoprincipiosdesign.Pagamento;

public class PagamentoBoleto implements IPagamento, IGeradorBoleto {
    @Override
    public void processar(double valor) {
        gerarBoleto(valor);
        pagar(valor);
    }

    private void pagar(double valor) {
        System.out.println("Pagamento via Boleto no valor de: " + valor);
    }

    @Override
    public void gerarBoleto(double valor) {
        System.out.println("Geração de boleto no valor de: " + valor);
    }
    
}
