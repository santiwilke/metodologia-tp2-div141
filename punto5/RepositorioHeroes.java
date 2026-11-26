package punto5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepositorioHeroes {
    private final List<Heroe> heroes = new ArrayList<>();

    public void agregar(Heroe heroe) {
        heroes.add(heroe);
    }

    public List<Heroe> obtenerTodos() {
        return heroes;
    }

    public Guerrero buscarMejorGuerrero() {
        return heroes.stream()
                .filter(h -> h instanceof Guerrero)
                .map(h -> (Guerrero) h)
                .max(Comparator.comparingInt(Guerrero::calcularPuntaje))
                .orElse(null);
    }
}
