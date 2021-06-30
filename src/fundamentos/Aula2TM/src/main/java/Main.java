package fundamentos.Aula2TM.src.main.java;



import fundamentos.Aula2TM.src.main.java.domain.*;

import javax.naming.OperationNotSupportedException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        ContaCorrente cc = new ContaCorrente(500,1000, "123-1");

        ContaCorrente cc2 = new ContaCorrente(100,100,"1234-1");

        try {
            cc.tranferencia(cc2,1500);
        } catch (OperationNotSupportedException e) {
            e.printStackTrace();
        }

        Counter counter = new Counter();

        counter.increase();

        System.out.println(counter);

        counter.increase(10);

        System.out.println(counter);


        Book b1 = new Book("HP", BigInteger.TEN,"alguem",true);

        try {
            b1.devolver();

            b1.emprestimo();

            System.out.println(b1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Fracao f1 = new Fracao(1,2);

        f1.adicionar(2.25);

        System.out.println("Fracao:" + f1);


        Data data = new Data(20,06,2021);

        System.out.println(data);

        data.addDay();

        System.out.println(data);
    }
}
