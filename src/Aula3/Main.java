package Aula3;

import Aula3.domain.Celular;
import Aula3.domain.Pessoa;
import Aula3.domain.Precedente;
import Aula3.util.SortUtil;

public class Main {
    public static void main(String[] args) {
        Pessoa p2 = new Pessoa("Robson", "87882728");

        Pessoa p1 = new Pessoa("Augusto","122222");

        Pessoa p3 = new Pessoa("Breno","9782672218");

        Pessoa p4 = new Pessoa("Yuri","09112627329");

        Pessoa[] list = new Pessoa[]{p1,p2,p3,p4};

        var ordered = SortUtil.sort(list);

        for (Pessoa p: ordered) {
            System.out.println(p);
        }

        System.out.println("-------------- Celulares --------------");

        Celular c1 = new Celular("998414116","Iago");
        Celular c2 = new Celular("999225986","Alex");
        Celular c3 = new Celular("999885467", "Gustavo");
        Celular c4 = new Celular("988653211", "Diego");

        var orderedCel = SortUtil.sort(new Celular[]{c1,c2,c3,c4});

        for (Celular c: orderedCel) {
            System.out.println(c);
        }
    }
}
