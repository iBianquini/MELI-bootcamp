package dakar.domain;

public class Moto extends Veiculo {
    public Moto(int velocidade, int aceleracao, int anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, 300, 2);
    }
}
