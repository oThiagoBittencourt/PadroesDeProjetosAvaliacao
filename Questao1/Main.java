package Questao1;

interface Transporte {
    double calcularTarifa(double valorBase);
}

class TransporteTerrestre implements Transporte {
    @Override
    public double calcularTarifa(double distanciaKm) {
        return distanciaKm * 2.5; // Exemplo: R$2,50 por km
    }
}

class TransporteAereo implements Transporte {
    @Override
    public double calcularTarifa(double pesoKg) {
        return pesoKg * 10.0; // Exemplo: R$10 por kg
    }
}

class TransporteMaritimo implements Transporte {
    @Override
    public double calcularTarifa(double volumeM3) {
        return volumeM3 * 5.0; // Exemplo: R$5 por m³
    }
}

// Fábrica (Factory Method)
class TransporteFactory {
    public static Transporte criarTransporte(String tipo) {
        switch (tipo.toLowerCase()) {
            case "terrestre":
                return new TransporteTerrestre();
            case "aereo":
                return new TransporteAereo();
            case "maritimo":
                return new TransporteMaritimo();
            default:
                throw new IllegalArgumentException("Tipo de transporte desconhecido: " + tipo);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Transporte t1 = TransporteFactory.criarTransporte("terrestre");
        Transporte t2 = TransporteFactory.criarTransporte("aereo");
        Transporte t3 = TransporteFactory.criarTransporte("maritimo");

        System.out.println("Tarifa terrestre: R$" + t1.calcularTarifa(120));   // distância
        System.out.println("Tarifa aérea: R$" + t2.calcularTarifa(15));        // peso
        System.out.println("Tarifa marítima: R$" + t3.calcularTarifa(8));      // volume
    }
}
