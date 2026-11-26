package transacciones;

import java.math.BigDecimal;
import java.util.Objects;

public record DatosOperacion(CuentaBancaria cuentaPrincipal, BigDecimal importe,
                             CuentaBancaria cuentaDestino) {
    public DatosOperacion {
        Objects.requireNonNull(cuentaPrincipal, "La cuenta principal es obligatoria.");
        Objects.requireNonNull(importe, "El importe es obligatorio.");
    }

    public DatosOperacion(CuentaBancaria cuentaPrincipal, BigDecimal importe) {
        this(cuentaPrincipal, importe, null);
    }
}
