package dakar.domain;

public class SocorristaCarro extends Veiculo implements SocorristaService<Carro>{

    public SocorristaCarro() {
        super(300, 200, 90, "000-00", 1000, 4);
    }

    @Override
    public void socorrer(Carro veiculo) {
        System.out.println("Socorrendo carro, placa: " + veiculo.getPlaca());
    }
}
