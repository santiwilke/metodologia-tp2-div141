package transacciones;

public final class Deposito implements OperacionBancaria {
    @Override
    public void ejecutar(DatosOperacion datos) {
        datos.cuentaPrincipal().acreditar(datos.importe());
    }
}
