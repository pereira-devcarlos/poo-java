package projetoprincipiosdesign.Pagamento;

public class PagamentoCartao implements Pagamento, Parcelavel {
    @Override
    public void pagar(double valor) {
        System.out.printf("Pagamento no cartão: R$ %.2f%n", valor);
    }

    @Override
    public void parcelar(double valor, int parcelas) {
        double valorParcela = valor / parcelas;
        System.out.printf("Parcelamento no cartão: %d parcelas de R$ %.2f%n", parcelas, valorParcela);
    }

}
