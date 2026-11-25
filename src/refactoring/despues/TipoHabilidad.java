package refactoring.despues;

// cada habilidad calcula su daño y se describe sola (antes era un if en Videojuego)
public interface TipoHabilidad {
    double calcularDano(double danoBase);
    String getNombre();
    String getEfecto();
}
