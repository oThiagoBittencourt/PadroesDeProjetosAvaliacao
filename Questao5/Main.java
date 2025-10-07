package Questao5;

// Interface Prototype
interface Documento extends Cloneable {
    Documento clonar();
    void exibirInfo();
    void setPersonalizacao(String cor, String fonte, String logo);
}

class ModeloDocumento implements Documento {
    private String tipo;
    private String cor;
    private String fonte;
    private String logo;

    public ModeloDocumento(String tipo, String cor, String fonte, String logo) {
        this.tipo = tipo;
        this.cor = cor;
        this.fonte = fonte;
        this.logo = logo;
    }

    @Override
    public Documento clonar() {
        try {
            return (Documento) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Erro ao clonar documento", e);
        }
    }

    @Override
    public void setPersonalizacao(String cor, String fonte, String logo) {
        this.cor = cor;
        this.fonte = fonte;
        this.logo = logo;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Modelo: " + tipo);
        System.out.println("Cor: " + cor);
        System.out.println("Fonte: " + fonte);
        System.out.println("Logo: " + logo);
        System.out.println("-------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        ModeloDocumento modeloCurriculo = new ModeloDocumento("Currículo", "Branco", "Arial", "Logo-Padrão");
        ModeloDocumento modeloProposta = new ModeloDocumento("Proposta Comercial", "Cinza", "Calibri", "Logo-Padrão");

        System.out.println("Modelos originais:");
        modeloCurriculo.exibirInfo();
        modeloProposta.exibirInfo();

        Documento curriculoClienteA = modeloCurriculo.clonar();
        curriculoClienteA.setPersonalizacao("Azul", "Verdana", "Logo-ClienteA");

        Documento propostaClienteB = modeloProposta.clonar();
        propostaClienteB.setPersonalizacao("Verde", "Times New Roman", "Logo-ClienteB");

        System.out.println("Modelos personalizados:");
        curriculoClienteA.exibirInfo();
        propostaClienteB.exibirInfo();
    }
}
