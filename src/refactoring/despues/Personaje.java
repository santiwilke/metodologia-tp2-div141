package refactoring.despues;

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

    // se movio desde Videojuego
    public double calcularDanoTotal() {
        return tipoHabilidad.calcularDano(dano);
    }

    // ya no hace falta preguntar que tipo de habilidad es
    public String getInfo() {
        return nombre + " tiene como daño " + dano + "\n"
             + "Habilidad tipo " + tipoHabilidad.getNombre() + "\n"
             + tipoHabilidad.getEfecto();
    }
}
