package fundamentos.laChiqui.domain;

public class Meli extends Convidado{
    public Meli(String nome) {
        super("MELI "+nome);
    }

    @Override
    public void comer() {
        System.out.println("Convidado MELI comendo...");
        System.out.println("Viva la Chiqui !!");
    }
}
