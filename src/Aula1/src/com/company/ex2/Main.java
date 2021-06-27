package Aula1.src.com.company.ex2;



import Aula1.src.com.company.ex2.domain.CarrinhoCompra;
import Aula1.src.com.company.ex2.domain.Enterprise;
import Aula1.src.com.company.ex2.domain.Produto;
import Aula1.src.com.company.ex2.service.ArrayService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {

        int input;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("\nInforme qual opção deseja usar: \n1 - atividade 1\n2 - atividade 2\n3 - atividade 3\n0 - sair");

            input = Integer.parseInt(reader.readLine());

            switch (input){
                case 1: {
                    Integer[] array = {52,10,85,1324,01,13,62,30,12,127};

                    ArrayService service = new ArrayService();

                    service.sortArray(array);
                }
                case 2: {
                    Enterprise empresaX = new Enterprise("Empresa X", new Date(),1.13);
                    Enterprise empresaY = new Enterprise("Empresa Y", new Date(),18.4);

                    Enterprise.compareEnterprises(empresaX,empresaY);
                }
                case 3:{
                    Produto[] prods = new Produto[3];
                    for (int i = 0; i < 3; i++) {
                        System.out.println("Digite o nome do produto "+i+": ");
                        String prodName = reader.readLine();

                        System.out.println("Digite o preço do produto "+i+": ");
                        double prodPrice = Double.parseDouble(reader.readLine());

                        System.out.println("Digite a qtd do produto "+i+": ");
                        int prodQtd = Integer.parseInt(reader.readLine());

                        prods[i] = new Produto(prodName,prodPrice,prodQtd);
                    }

                    CarrinhoCompra compras = new CarrinhoCompra(prods);

                    System.out.println(compras);

                }
            }

        } while(input != 0);

    }
}
