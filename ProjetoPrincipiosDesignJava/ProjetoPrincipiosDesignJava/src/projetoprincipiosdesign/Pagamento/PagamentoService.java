package projetoprincipiosdesign.Pagamento;

import projetoprincipiosdesign.Enum.FormaPagamento;

public class PagamentoService {
    public void processarPagamento(FormaPagamento formaPagamento, double valor, int numeroParcelas) {
        switch (formaPagamento) {
            case BOLETO -> {
                PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
                pagamentoBoleto.gerarBoleto(valor);
                pagamentoBoleto.pagar(valor);
            }
            case CARTAO -> {
                if(numeroParcelas < 0) {
                    throw new IllegalArgumentException("Número de parcelas não pode ser menor que zero.");
                } else if(numeroParcelas > 12) {
                    throw new IllegalArgumentException("Número de parcelas não pode ser maior que 12.");
                } else {
                    PagamentoCartao pagamentoCartao = new PagamentoCartao();
                    if (numeroParcelas == 0) {
                        pagamentoCartao.pagar(valor);
                    } else {
                        pagamentoCartao.parcelar(valor, numeroParcelas);
                    }
                }
            }
            case PIX -> {
                PagamentoPix pagamentoPix = new PagamentoPix();
                pagamentoPix.pagar(valor);
            }
        }
    }
}
