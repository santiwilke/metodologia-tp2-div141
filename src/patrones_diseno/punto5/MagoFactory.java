package punto5;

import java.time.LocalDate;

public class MagoFactory implements HeroeFactory {
    private String nombre;
    private String apodo;
    private LocalDate fechaCreacion;
    private int reservaMana;

    public MagoFactory(String nombre, String apodo, LocalDate fechaCreacion, int reservaMana) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.fechaCreacion = fechaCreacion;
        this.reservaMana = reservaMana;
    }

    @Override
    public Heroe crearHeroe() {
        return new Mago(nombre, apodo, fechaCreacion, reservaMana);
    }
}
