package refactoring.antes;

public class HabilidadMagica implements TipoHabilidad {
    @Override
    public double calcularDano(double danoBase) {
        return danoBase * 2; // "dobla tu fuerza"
    }
}
