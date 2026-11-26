package punto5;

public class Gremio {
    private String nombre;

    public Gremio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Heroe solicitarReclutamiento(HeroeFactory factory) {
        return GestorHeroes.getInstance().reclutarHeroe(factory);
    }

    public Guerrero consultarMejorGuerrero() {
        return GestorHeroes.getInstance().consultarMejorGuerrero();
    }

    public String solicitarReporteBatalla() {
        return GestorHeroes.getInstance().generarReporteBatalla();
    }
}
