package Questao3;

import java.util.ArrayList;
import java.util.List;

// Interface Observer
interface Observador {
    void atualizar(String noticia);
}

interface Sujeito {
    void registrar(Observador o);
    void remover(Observador o);
    void notificar(String noticia);
}

class Topico implements Sujeito {
    private String nome;
    private List<Observador> leitores = new ArrayList<>();

    public Topico(String nome) {
        this.nome = nome;
    }

    @Override
    public void registrar(Observador o) {
        leitores.add(o);
    }

    @Override
    public void remover(Observador o) {
        leitores.remove(o);
    }

    @Override
    public void notificar(String noticia) {
        for (Observador leitor : leitores) {
            leitor.atualizar("[" + nome + "] " + noticia);
        }
    }

    public void publicarNoticia(String noticia) {
        System.out.println("Nova notícia publicada em " + nome + ": " + noticia);
        notificar(noticia);
    }
}

// Implementação concreta do Observer
class Leitor implements Observador {
    private String nome;

    public Leitor(String nome) {
        this.nome = nome;
    }

    @Override
    public void atualizar(String noticia) {
        System.out.println(nome + " recebeu: " + noticia);
    }
}

public class Main {
    public static void main(String[] args) {
        Topico politica = new Topico("Política");
        Topico esportes = new Topico("Esportes");
        Topico tecnologia = new Topico("Tecnologia");

        Leitor ana = new Leitor("Ana");
        Leitor bruno = new Leitor("Bruno");
        Leitor carla = new Leitor("Carla");

        politica.registrar(ana);
        politica.registrar(bruno);

        esportes.registrar(bruno);
        esportes.registrar(carla);

        tecnologia.registrar(ana);

        politica.publicarNoticia("Novo projeto de lei é aprovado.");
        esportes.publicarNoticia("Time local vence campeonato.");
        tecnologia.publicarNoticia("Novo smartphone é lançado.");
    }
}
