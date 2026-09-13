package projetoprincipiosdesign.Pagamento;

public class PagamentoCartao implements IPagamento, IParcelavel {
    private final int parcelas;

    public PagamentoCartao() {
        this(0);
    }

    public PagamentoCartao(int parcelas) {
        if (parcelas < 0 || parcelas > 12) {
            throw new IllegalArgumentException("Número de parcelas deve estar entre 0 e 12.");
        }
        this.parcelas = parcelas;
    }

    @Override
    public void processar(double valor) {
        if (parcelas == 0) {
            pagar(valor);
        } else {
            parcelar(valor, parcelas);
        }
    }

    private void pagar(double valor) {
        System.out.printf("Pagamento no cartão: R$ %.2f%n", valor);
    }

    @Override
    public void parcelar(double valor, int parcelas) {
        double valorParcela = valor / parcelas;
        System.out.printf("Parcelamento no cartão: %d parcelas de R$ %.2f%n", parcelas, valorParcela);
    }

}
