package projetoprincipiosdesign.Pagamento;

public class PagamentoPix implements Pagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento via Pix no valor de: " + valor);
    }
}
