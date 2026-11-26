package punto3;

public class Main {

    public static void main(String[] args) {
        Personaje guerrero = new Guerrero();
        Personaje mago = new Mago();

        guerrero.combatir();
        System.out.println();
        mago.combatir();
    }
}
