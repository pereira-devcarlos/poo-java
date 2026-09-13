package projetoprincipiosdesign.Pagamento;

public class PagamentoPix implements IPagamento {
    @Override
    public void processar(double valor) {
        System.out.println("Pagamento via Pix no valor de: " + valor);
    }
}
