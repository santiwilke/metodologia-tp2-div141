package refactoring.despues;

public class Main {
    public static void main(String[] args) {
        Videojuego juego = new Videojuego();
        Personaje merlin = new Personaje("Merlín", 40, new HabilidadMagica());
        Personaje conan = new Personaje("Conan", 70, new HabilidadCuerpoACuerpo());
        juego.agregarPersonaje(merlin);
        juego.agregarPersonaje(conan);

        juego.imprimirInfo(merlin);
        juego.imprimirInfo(conan);
        System.out.println("Personaje con más daño: " + juego.personajeConMasDano().getNombre());
    }
}
