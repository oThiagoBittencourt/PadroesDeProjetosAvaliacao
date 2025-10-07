package Questao4;

interface Relatorio {
    void gerar();
}

class RelatorioBasico implements Relatorio {
    @Override
    public void gerar() {
        System.out.println("Gerando relatório básico com lista de pedidos...");
    }
}

// Classe abstrata Decorator
abstract class RelatorioDecorator implements Relatorio {
    protected Relatorio relatorioDecorado;

    public RelatorioDecorator(Relatorio relatorio) {
        this.relatorioDecorado = relatorio;
    }

    @Override
    public void gerar() {
        relatorioDecorado.gerar();
    }
}

// Decoradores concretos
class RelatorioComEstatisticas extends RelatorioDecorator {
    public RelatorioComEstatisticas(Relatorio relatorio) {
        super(relatorio);
    }

    @Override
    public void gerar() {
        super.gerar();
        adicionarEstatisticas();
    }

    private void adicionarEstatisticas() {
        System.out.println("Adicionando estatísticas de faturamento...");
    }
}

class RelatorioComGraficos extends RelatorioDecorator {
    public RelatorioComGraficos(Relatorio relatorio) {
        super(relatorio);
    }

    @Override
    public void gerar() {
        super.gerar();
        adicionarGraficos();
    }

    private void adicionarGraficos() {
        System.out.println("Gerando gráficos de desempenho...");
    }
}

class RelatorioComPDF extends RelatorioDecorator {
    public RelatorioComPDF(Relatorio relatorio) {
        super(relatorio);
    }

    @Override
    public void gerar() {
        super.gerar();
        exportarPDF();
    }

    private void exportarPDF() {
        System.out.println("Exportando relatório em formato PDF...");
    }
}

public class Main {
    public static void main(String[] args) {
        Relatorio relatorio1 = new RelatorioBasico();
        relatorio1.gerar();

        System.out.println("\n--- Relatório com estatísticas ---");
        Relatorio relatorio2 = new RelatorioComEstatisticas(new RelatorioBasico());
        relatorio2.gerar();

        System.out.println("\n--- Relatório completo ---");
        Relatorio relatorio3 = new RelatorioComPDF(
                                   new RelatorioComGraficos(
                                       new RelatorioComEstatisticas(
                                           new RelatorioBasico())));
        relatorio3.gerar();
    }
}
