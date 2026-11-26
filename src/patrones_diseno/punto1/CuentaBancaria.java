package transacciones;

import java.math.BigDecimal;
import java.util.Objects;

public final class CuentaBancaria {
    private final String numero;
    private BigDecimal saldo;

    public CuentaBancaria(String numero, BigDecimal saldoInicial) {
        this.numero = Objects.requireNonNull(numero, "El número de cuenta es obligatorio.");
        this.saldo = Objects.requireNonNull(saldoInicial, "El saldo inicial es obligatorio.");
        if (saldoInicial.signum() < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo.");
        }
    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    void acreditar(BigDecimal importe) {
        validarImporte(importe);
        saldo = saldo.add(importe);
    }

    void debitar(BigDecimal importe) {
        if (saldo.compareTo(importe) < 0) {
            throw new IllegalStateException("Saldo insuficiente en la cuenta " + numero + ".");
        }
        validarImporte(importe);
        saldo = saldo.subtract(importe);
    }

    private static void validarImporte(BigDecimal importe) {
        if (importe.signum() <= 0) {
            throw new IllegalArgumentException("El importe debe ser mayor que cero.");
        }
    }
}
