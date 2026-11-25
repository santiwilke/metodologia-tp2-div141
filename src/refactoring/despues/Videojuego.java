package refactoring.despues;

import java.util.ArrayList;
import java.util.List;

public class Videojuego {
    private List<Personaje> personajes = new ArrayList<>();

    public void agregarPersonaje(Personaje p) { personajes.add(p); }

    public Personaje personajeConMasDano() {
        Personaje conMasDano = null;
        double max = 0;
        for (Personaje p : personajes) {
            double dano = p.calcularDanoTotal();
            if (dano > max) {
                conMasDano = p;
                max = dano;
            }
        }
        return conMasDano;
    }

    public void imprimirInfo(Personaje p) {
        System.out.println(p.getInfo());
    }
}
