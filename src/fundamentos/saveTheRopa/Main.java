package fundamentos.saveTheRopa;

import fundamentos.saveTheRopa.domain.Calcado;
import fundamentos.saveTheRopa.domain.GuardaRoupa;
import fundamentos.saveTheRopa.domain.Roupa;
import fundamentos.saveTheRopa.domain.Vestuario;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GuardaRoupa guardaRoupa = new GuardaRoupa();

        List<Vestuario> lista1 = new ArrayList<>();
        Calcado tenis1 = new Calcado("Nike","M1");
        lista1.add(tenis1);

        List<Vestuario> lista2 = new ArrayList<>();
        Calcado tenis2 = new Calcado("Adidas","Pro");
        lista2.add(tenis2);
        Roupa roupa1 = new Roupa("Puma","Casaco");
        lista2.add(roupa1);

        int ticket1 = guardaRoupa.guardarRoupas(lista1);

        guardaRoupa.mostrarVestuario();

        int ticket2 = guardaRoupa.guardarRoupas(lista2);

        List<Vestuario> ret1 = guardaRoupa.devolverVestuarios(ticket1);
        System.out.println(ret1);

        System.out.println("O que sobrou: ");
        guardaRoupa.mostrarVestuario();

        List<Vestuario> ret2 = guardaRoupa.devolverVestuarios(ticket2);
        System.out.println("Ultima retirada: ");
        System.out.println(ret2);

    }
}
