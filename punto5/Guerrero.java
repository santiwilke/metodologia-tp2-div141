package punto5;

import java.time.LocalDate;

public class Guerrero extends Heroe {
    private int poderAtaque;
    private int numeroVictorias;
    private int bonoPorVictoria;

    public Guerrero(String nombre, String apodo, LocalDate fechaCreacion,
                    int poderAtaque, int numeroVictorias, int bonoPorVictoria) {
        super(nombre, apodo, fechaCreacion);
        this.poderAtaque = poderAtaque;
        this.numeroVictorias = numeroVictorias;
        this.bonoPorVictoria = bonoPorVictoria;
    }

    public int getPoderAtaque() {
        return poderAtaque;
    }

    public int getNumeroVictorias() {
        return numeroVictorias;
    }

    public int getBonoPorVictoria() {
        return bonoPorVictoria;
    }

    public int calcularPuntaje() {
        return poderAtaque + (numeroVictorias * bonoPorVictoria);
    }
}
