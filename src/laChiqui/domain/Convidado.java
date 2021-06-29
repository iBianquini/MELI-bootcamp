package laChiqui.domain;

public abstract class Convidado {
    private String nome;

    public Convidado(String nome) {
        this.nome = nome;
    }

    public abstract void comer();
}
