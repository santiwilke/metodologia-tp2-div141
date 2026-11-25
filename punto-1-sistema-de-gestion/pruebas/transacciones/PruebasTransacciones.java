package transacciones;

import java.math.BigDecimal;

public class PruebasTransacciones {
    public static void main(String[] args) {
        probarDepositoYExtraccion();
        probarCambioAntesDeConfirmar();
        probarMontosInvalidos();
        probarSaldoInsuficienteAlConfirmar();
        probarDestinoInvalido();
        probarConfirmacionSinSeleccion();
        System.out.println("Todas las pruebas pasaron.");
    }

    private static void probarDepositoYExtraccion() {
        CuentaBancaria cuenta = cuenta("A", "100.10");
        seleccionar(new Deposito(), new DatosOperacion(cuenta, monto("0.20"))).confirmar();
        verificarSaldo(cuenta, "100.30");

        seleccionar(new Extraccion(), new DatosOperacion(cuenta, monto("100.30"))).confirmar();
        verificarSaldo(cuenta, "0");
    }

    private static void probarCambioAntesDeConfirmar() {
        CuentaBancaria origen = cuenta("A", "1000");
        CuentaBancaria destino = cuenta("B", "200");
        Transaccion transaccion = seleccionar(new Deposito(), new DatosOperacion(origen, monto("300")));
        verificarSaldo(origen, "1000");

        DatosOperacion datos = new DatosOperacion(origen, monto("300"), destino);
        transaccion.seleccionarOperacion(new Transferencia(), datos);
        verificarSaldo(origen, "1000");
        verificarSaldo(destino, "200");

        transaccion.confirmar();
        esperarError(IllegalStateException.class, transaccion::confirmar);
        esperarError(IllegalStateException.class, () -> transaccion.seleccionarOperacion(new Transferencia(), datos));
        verificarSaldo(origen, "700");
        verificarSaldo(destino, "500");
    }

    private static void probarMontosInvalidos() {
        CuentaBancaria origen = cuenta("A", "100");
        CuentaBancaria destino = cuenta("B", "20");

        Transaccion deposito = seleccionar(new Deposito(), new DatosOperacion(origen, monto("0")));
        esperarError(IllegalArgumentException.class, deposito::confirmar);
        Transaccion extraccion = seleccionar(new Extraccion(), new DatosOperacion(origen, monto("-5")));
        esperarError(IllegalArgumentException.class, extraccion::confirmar);
        Transaccion transferencia = seleccionar(new Transferencia(), new DatosOperacion(origen, monto("-5"), destino));
        esperarError(IllegalArgumentException.class, transferencia::confirmar);

        verificarSaldo(origen, "100");
        verificarSaldo(destino, "20");
    }

    private static void probarSaldoInsuficienteAlConfirmar() {
        CuentaBancaria origen = cuenta("A", "100");
        CuentaBancaria destino = cuenta("B", "20");
        Transaccion pendiente = seleccionar(new Transferencia(), new DatosOperacion(origen, monto("80"), destino));

        // Otra operación cambia el saldo después de la selección.
        seleccionar(new Extraccion(), new DatosOperacion(origen, monto("30"))).confirmar();
        esperarError(IllegalStateException.class, pendiente::confirmar);
        verificarSaldo(origen, "70");
        verificarSaldo(destino, "20");

        pendiente.seleccionarOperacion(new Transferencia(), new DatosOperacion(origen, monto("50"), destino));
        pendiente.confirmar();
        verificarSaldo(origen, "20");
        verificarSaldo(destino, "70");
    }

    private static void probarDestinoInvalido() {
        CuentaBancaria origen = cuenta("A", "100");
        Transaccion sinDestino = seleccionar(new Transferencia(), new DatosOperacion(origen, monto("50")));
        esperarError(IllegalArgumentException.class, sinDestino::confirmar);
        Transaccion mismaCuenta = seleccionar(new Transferencia(), new DatosOperacion(origen, monto("50"), origen));
        esperarError(IllegalArgumentException.class, mismaCuenta::confirmar);
        verificarSaldo(origen, "100");
    }

    private static void probarConfirmacionSinSeleccion() {
        esperarError(IllegalStateException.class, new Transaccion()::confirmar);
    }

    private static Transaccion seleccionar(OperacionBancaria operacion, DatosOperacion datos) {
        Transaccion transaccion = new Transaccion();
        transaccion.seleccionarOperacion(operacion, datos);
        return transaccion;
    }

    private static CuentaBancaria cuenta(String numero, String saldo) {
        return new CuentaBancaria(numero, monto(saldo));
    }

    private static BigDecimal monto(String valor) {
        return new BigDecimal(valor);
    }

    private static void verificarSaldo(CuentaBancaria cuenta, String esperado) {
        if (cuenta.getSaldo().compareTo(monto(esperado)) != 0) {
            throw new AssertionError("Cuenta " + cuenta.getNumero() + ": se esperaba " + esperado
                    + ", pero el saldo fue " + cuenta.getSaldo());
        }
    }

    private static void esperarError(Class<? extends RuntimeException> tipo, Runnable accion) {
        try {
            accion.run();
        } catch (RuntimeException e) {
            if (tipo.isInstance(e)) {
                return;
            }
            throw e;
        }
        throw new AssertionError("Se esperaba " + tipo.getSimpleName());
    }
}
