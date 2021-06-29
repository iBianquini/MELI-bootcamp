package dakar;

import dakar.domain.*;

import java.math.BigDecimal;

public class MainCorrida {

    public static void main(String[] args) {
        Corrida corrida = new Corrida(150, BigDecimal.valueOf(200000), "Meli Race", 5);

        SocorristaCarro a1 = null;
        Carro v1 = null;
        Moto v3 = null;
        SocorristaMoto a2 = null;
        try {

            v1 = new Carro(120, 80, 30, "BBO-3700");
            corrida.registrarCarro(v1.getVelocidade(), v1.getAceleracao(), v1.getAnguloDeGiro(), v1.getPlaca());

            Carro v2 = new Carro(200, 80, 30, "MMl-1200");
            corrida.registrarCarro(v2.getVelocidade(), v2.getAceleracao(), v2.getAnguloDeGiro(), v2.getPlaca());

            v3 = new Moto(200, 100, 30, "JJO-9987");
            corrida.registrarCarro(v3.getVelocidade(), v3.getAceleracao(), v3.getAnguloDeGiro(), v3.getPlaca());

            a1 = new SocorristaCarro();
            corrida.registrarCarro(a1.getVelocidade(), a1.getAceleracao(), a1.getAnguloDeGiro(), a1.getPlaca());

            a2 = new SocorristaMoto();
            corrida.registrarCarro(a2.getVelocidade(), a2.getAceleracao(), a2.getAnguloDeGiro(), a2.getPlaca());

            System.out.println("Nao deve inserir: ");
            Carro v4 = new Carro(120, 80, 30, "BUO-3700");
            corrida.registrarCarro(v4.getVelocidade(), v4.getAceleracao(), v4.getAnguloDeGiro(), v4.getPlaca());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        } finally {

            corrida.iniciarCorrida();

            assert a1 != null;
            a1.socorrer(v1);

            assert a2 != null;
            a2.socorrer(v3);

            var vencedor = corrida.definirVencedor();

            System.out.println("O vencedor é: " + vencedor.toString());
        }
    }
}
