package refactoring.antes;

public class HabilidadCuerpoACuerpo implements TipoHabilidad {
    @Override
    public double calcularDano(double danoBase) {
        return danoBase; // "mantiene tu fuerza"
    }
}
