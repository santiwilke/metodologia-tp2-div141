package punto5;

import java.time.LocalDate;

public class GuerreroFactory implements HeroeFactory {
    private String nombre;
    private String apodo;
    private LocalDate fechaCreacion;
    private int poderAtaque;
    private int numeroVictorias;
    private int bonoPorVictoria;

    public GuerreroFactory(String nombre, String apodo, LocalDate fechaCreacion,
                           int poderAtaque, int numeroVictorias, int bonoPorVictoria) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.fechaCreacion = fechaCreacion;
        this.poderAtaque = poderAtaque;
        this.numeroVictorias = numeroVictorias;
        this.bonoPorVictoria = bonoPorVictoria;
    }

    @Override
    public Heroe crearHeroe() {
        return new Guerrero(nombre, apodo, fechaCreacion, poderAtaque, numeroVictorias, bonoPorVictoria);
    }
}
