package fundamentos.laChiqui.domain;

public class Regular extends Convidado{
    public Regular(String nome) {
        super("REGULAR " + nome);
    }

    @Override
    public void comer() {
        System.out.println("Convidado REGULAR comendo...");
    }
}
