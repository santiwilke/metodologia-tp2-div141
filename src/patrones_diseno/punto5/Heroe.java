package punto5;

import java.time.LocalDate;

public abstract class Heroe {
    protected String nombre;
    protected String apodo;
    protected LocalDate fechaCreacion;

    public Heroe(String nombre, String apodo, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
}
