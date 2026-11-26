package punto3;

public class Guerrero extends Personaje {

    @Override
    protected void prepararCombate() {
        System.out.println("Guerrero: preparando el arma y equipando la armadura.");
    }

    @Override
    protected void alistarseParaAtacar() {
        System.out.println("Guerrero: acercándose al enemigo.");
    }

    @Override
    protected void ejecutarAtaque() {
        System.out.println("Guerrero: ejecutando ataque físico.");
    }

    @Override
    protected void aplicarEfectoPostCombate() {
        System.out.println("Guerrero: lanzando un grito de guerra.");
    }
}
