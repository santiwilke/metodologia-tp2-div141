package punto5;

import java.time.LocalDate;

public class Mago extends Heroe {
    private int reservaMana;

    public Mago(String nombre, String apodo, LocalDate fechaCreacion, int reservaMana) {
        super(nombre, apodo, fechaCreacion);
        this.reservaMana = reservaMana;
    }

    public int getReservaMana() {
        return reservaMana;
    }
}
