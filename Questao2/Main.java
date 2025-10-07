package Questao2;

interface ProcessadorPagamento {
    void processar(double valor);
}

class ProcessadorCartaoCredito implements ProcessadorPagamento {
    @Override
    public void processar(double valor) {
        System.out.println("Processando pagamento de R$" + valor + " via Cartão de Crédito...");
    }
}

class ProcessadorBoleto implements ProcessadorPagamento {
    @Override
    public void processar(double valor) {
        System.out.println("Gerando boleto no valor de R$" + valor + "...");
    }
}

class ProcessadorPix implements ProcessadorPagamento {
    @Override
    public void processar(double valor) {
        System.out.println("Enviando pagamento PIX de R$" + valor + "...");
    }
}

// Abstract Factory
interface PagamentoFactory {
    ProcessadorPagamento criarProcessador();
}

// Fábricas concretas
class CartaoCreditoFactory implements PagamentoFactory {
    @Override
    public ProcessadorPagamento criarProcessador() {
        return new ProcessadorCartaoCredito();
    }
}

class BoletoFactory implements PagamentoFactory {
    @Override
    public ProcessadorPagamento criarProcessador() {
        return new ProcessadorBoleto();
    }
}

class PixFactory implements PagamentoFactory {
    @Override
    public ProcessadorPagamento criarProcessador() {
        return new ProcessadorPix();
    }
}

public class Main {
    public static void main(String[] args) {
        PagamentoFactory factory;

        String tipoPagamento = "pix";

        switch (tipoPagamento.toLowerCase()) {
            case "cartao":
                factory = new CartaoCreditoFactory();
                break;
            case "boleto":
                factory = new BoletoFactory();
                break;
            case "pix":
                factory = new PixFactory();
                break;
            default:
                throw new IllegalArgumentException("Tipo de pagamento inválido.");
        }

        ProcessadorPagamento processador = factory.criarProcessador();
        processador.processar(250.00);
    }
}
