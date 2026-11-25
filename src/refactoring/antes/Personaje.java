package refactoring.antes;

public class Personaje {
    private String nombre;
    private double dano;
    private TipoHabilidad tipoHabilidad;

    public Personaje(String nombre, double dano, TipoHabilidad tipoHabilidad) {
        this.nombre = nombre;
        this.dano = dano;
        this.tipoHabilidad = tipoHabilidad;
    }

    public String getNombre() { return nombre; }
    public double getDano() { return dano; }
    public TipoHabilidad getTipoHabilidad() { return tipoHabilidad; }
}
