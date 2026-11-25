package refactoring.antes;

import java.util.ArrayList;
import java.util.List;

// codigo original de la consigna (solo se arreglaron los errores para que compile)
public class Videojuego {
    private List<Personaje> personajes = new ArrayList<>();

    public void agregarPersonaje(Personaje p) { personajes.add(p); }

    public Personaje personajeConMasDano() {
        Personaje temp = null;
        double max = 0;
        for (Personaje p : personajes) {
            double dano = p.getTipoHabilidad().calcularDano(p.getDano());
            if (dano > max) {
                temp = p;
                max = dano;
            }
        }
        return temp;
    }

    public void imprimirInfo(Personaje p) {
        System.out.println(p.getNombre() + "tiene como daño " + p.getDano());
        if (p.getTipoHabilidad().getClass() == HabilidadMagica.class) {
            System.out.println("Habilidad tipo habilidad mágica");
            System.out.println("Esta habilidad dobla tu fuerza");
        } else {
            System.out.println("Habilidad tipo habilidad Cuerpo a cuerpo");
            System.out.println("Este habilidad mantiene tu fuerza");
        }
    }
}
