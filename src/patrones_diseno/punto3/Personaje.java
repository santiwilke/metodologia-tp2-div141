package punto3;

public abstract class Personaje {

    public final void combatir() {
        prepararCombate();
        alistarseParaAtacar();
        ejecutarAtaque();
        evaluarResultado();
        aplicarEfectoPostCombate();
    }

    protected abstract void prepararCombate();

    protected abstract void alistarseParaAtacar();

    protected abstract void ejecutarAtaque();

    protected final void evaluarResultado() {
        System.out.println("Evaluando el resultado del combate...");
    }

    protected void aplicarEfectoPostCombate() {
    }
}
