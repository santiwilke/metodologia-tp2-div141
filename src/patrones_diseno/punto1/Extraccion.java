package transacciones;

public final class Extraccion implements OperacionBancaria {
    @Override
    public void ejecutar(DatosOperacion datos) {
        datos.cuentaPrincipal().debitar(datos.importe());
    }
}
