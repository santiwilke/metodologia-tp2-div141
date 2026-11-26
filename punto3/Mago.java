package punto3;

public class Mago extends Personaje {

    @Override
    protected void prepararCombate() {
        System.out.println("Mago: seleccionando hechizo y preparando el bastón.");
    }

    @Override
    protected void alistarseParaAtacar() {
        System.out.println("Mago: concentrando energía mágica.");
    }

    @Override
    protected void ejecutarAtaque() {
        System.out.println("Mago: ejecutando ataque mágico.");
    }
}
