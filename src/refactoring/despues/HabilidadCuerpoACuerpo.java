package refactoring.despues;

public class HabilidadCuerpoACuerpo implements TipoHabilidad {
    @Override
    public double calcularDano(double danoBase) {
        return danoBase;
    }

    @Override
    public String getNombre() {
        return "habilidad Cuerpo a cuerpo";
    }

    @Override
    public String getEfecto() {
        return "Esta habilidad mantiene tu fuerza";
    }
}
