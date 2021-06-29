package dakar.domain;

public class SocorristaMoto extends Veiculo implements SocorristaService<Moto>{
    public SocorristaMoto() {
        super(300, 300, 90, "999-99", 1000, 4);
    }

    @Override
    public void socorrer(Moto veiculo) {
        System.out.println("Socorrendo Motocicleta, placa: " + veiculo.getPlaca());
    }
}
