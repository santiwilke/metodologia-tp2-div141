package transacciones;

public final class Transferencia implements OperacionBancaria {
    @Override
    public void ejecutar(DatosOperacion datos) {
        CuentaBancaria origen = datos.cuentaPrincipal();
        CuentaBancaria destino = datos.cuentaDestino();
        if (destino == null || origen.getNumero().equals(destino.getNumero())) {
            throw new IllegalArgumentException("La transferencia requiere una cuenta de destino distinta.");
        }

        // El débito verifica el saldo y el importe antes de modificar la cuenta de origen.
        origen.debitar(datos.importe());
        destino.acreditar(datos.importe());
    }
}
