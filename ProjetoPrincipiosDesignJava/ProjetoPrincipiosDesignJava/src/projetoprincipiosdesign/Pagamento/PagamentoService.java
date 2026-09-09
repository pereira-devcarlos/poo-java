package projetoprincipiosdesign.Pagamento;

import projetoprincipiosdesign.Enum.FormaPagamento;

public class PagamentoService {
    public void processarPagamento(FormaPagamento formaPagamento, double valor, int numeroParcelas) {
        switch (formaPagamento) {
            case BOLETO -> {
                PagamentoBoleto pagamentoBoleto = new PagamentoBoleto();
                System.out.println("================ Pagamento com boleto ================");
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
                    System.out.println("================ Pagamento com cartão de crédito ================");

                    if (numeroParcelas == 0) {
                        pagamentoCartao.pagar(valor);
                    } else {
                        pagamentoCartao.parcelar(valor, numeroParcelas);   
                    }
                }
            }
            case PIX -> {
                PagamentoPix pagamentoPix = new PagamentoPix();
                System.out.println("================ Pagamento com PIX ================");
                pagamentoPix.pagar(valor);
            }
        }
    }
}
