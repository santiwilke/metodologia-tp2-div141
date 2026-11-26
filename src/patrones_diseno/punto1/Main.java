package transacciones;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuentaA = new CuentaBancaria("A", new BigDecimal("1000"));
        CuentaBancaria cuentaB = new CuentaBancaria("B", new BigDecimal("200"));
        Transaccion transaccion = new Transaccion();
        String seleccion = "ninguna";

        try (Scanner entrada = new Scanner(System.in)) {
            while (true) {
                System.out.printf("%nSaldos: A $%s | B $%s%n",
                        cuentaA.getSaldo().toPlainString(), cuentaB.getSaldo().toPlainString());
                System.out.println("Operación pendiente: " + seleccion);
                System.out.println("1. Depósito | 2. Extracción | 3. Transferencia | 4. Confirmar | 0. Salir");
                System.out.print("Opción: ");
                if (!entrada.hasNextLine()) {
                    return;
                }
                String opcion = entrada.nextLine().trim();

                try {
                    switch (opcion) {
                        case "1" -> {
                            CuentaBancaria cuenta = leerCuenta(entrada, "Cuenta a acreditar", cuentaA, cuentaB);
                            transaccion.seleccionarOperacion(new Deposito(), new DatosOperacion(cuenta, leerImporte(entrada)));
                            seleccion = "Depósito";
                        }
                        case "2" -> {
                            CuentaBancaria cuenta = leerCuenta(entrada, "Cuenta a debitar", cuentaA, cuentaB);
                            transaccion.seleccionarOperacion(new Extraccion(), new DatosOperacion(cuenta, leerImporte(entrada)));
                            seleccion = "Extracción";
                        }
                        case "3" -> {
                            CuentaBancaria origen = leerCuenta(entrada, "Cuenta de origen", cuentaA, cuentaB);
                            CuentaBancaria destino = leerCuenta(entrada, "Cuenta de destino", cuentaA, cuentaB);
                            transaccion.seleccionarOperacion(new Transferencia(),
                                    new DatosOperacion(origen, leerImporte(entrada), destino));
                            seleccion = "Transferencia";
                        }
                        case "4" -> {
                            transaccion.confirmar();
                            System.out.println("Transacción confirmada.");
                            transaccion = new Transaccion();
                            seleccion = "ninguna";
                        }
                        case "0" -> {
                            return;
                        }
                        default -> System.out.println("Opción inválida.");
                    }
                } catch (IllegalArgumentException | IllegalStateException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Entrada finalizada. No se ejecutó la operación pendiente.");
        }
    }

    private static CuentaBancaria leerCuenta(Scanner entrada, String mensaje, CuentaBancaria cuentaA,
                                            CuentaBancaria cuentaB) {
        System.out.print(mensaje + " (A/B): ");
        return switch (entrada.nextLine().trim().toUpperCase(Locale.ROOT)) {
            case "A" -> cuentaA;
            case "B" -> cuentaB;
            default -> throw new IllegalArgumentException("Elegí la cuenta A o B.");
        };
    }

    private static BigDecimal leerImporte(Scanner entrada) {
        System.out.print("Importe: ");
        String texto = entrada.nextLine().trim().replace(',', '.');
        try {
            return new BigDecimal(texto);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ingresá un importe numérico.");
        }
    }
}
