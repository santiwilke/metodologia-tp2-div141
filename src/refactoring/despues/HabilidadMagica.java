package refactoring.despues;

public class HabilidadMagica implements TipoHabilidad {
    @Override
    public double calcularDano(double danoBase) {
        return danoBase * 2;
    }

    @Override
    public String getNombre() {
        return "habilidad mágica";
    }

    @Override
    public String getEfecto() {
        return "Esta habilidad dobla tu fuerza";
    }
}
