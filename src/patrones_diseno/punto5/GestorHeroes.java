package punto5;

public class GestorHeroes {
    private static GestorHeroes instancia;
    private final RepositorioHeroes repositorio;
    private final GeneradorReportes generadorReportes;

    private GestorHeroes() {
        this.repositorio = new RepositorioHeroes();
        this.generadorReportes = new GeneradorReportes();
    }

    public static GestorHeroes getInstance() {
        if (instancia == null) {
            instancia = new GestorHeroes();
        }
        return instancia;
    }

    public Heroe reclutarHeroe(HeroeFactory factory) {
        Heroe nuevo = factory.crearHeroe();
        repositorio.agregar(nuevo);
        return nuevo;
    }

    public Guerrero consultarMejorGuerrero() {
        return repositorio.buscarMejorGuerrero();
    }

    public String generarReporteBatalla() {
        return generadorReportes.generarReporte(repositorio.obtenerTodos());
    }
}
