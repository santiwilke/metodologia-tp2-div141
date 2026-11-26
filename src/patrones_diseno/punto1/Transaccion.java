package transacciones;

import java.util.Objects;

public final class Transaccion {
    private OperacionBancaria operacion;
    private DatosOperacion datos;
    private boolean confirmada;

    public void seleccionarOperacion(OperacionBancaria operacion, DatosOperacion datos) {
        verificarPendiente();
        Objects.requireNonNull(datos, "Los datos de la operación son obligatorios.");
        this.operacion = Objects.requireNonNull(operacion, "La operación es obligatoria.");
        this.datos = datos;
    }

    public void confirmar() {
        verificarPendiente();
        if (operacion == null) {
            throw new IllegalStateException("Primero seleccioná una operación.");
        }
        operacion.ejecutar(datos);
        confirmada = true;
    }

    private void verificarPendiente() {
        if (confirmada) {
            throw new IllegalStateException("La transacción ya fue confirmada.");
        }
    }
}
