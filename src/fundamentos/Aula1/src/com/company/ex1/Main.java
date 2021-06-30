package fundamentos.Aula1.src.com.company.ex1;



import fundamentos.Aula1.src.com.company.ex1.service.Interface.IMathService;
import fundamentos.Aula1.src.com.company.ex1.service.MathService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	    int input;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	    do {
            System.out.println("\nInforme qual opção deseja usar: \n1 - Números pares\n2 - Multiplos\n3 - Válidar primo\n4 - Primeiros n primos\n5 - Naturais\n0 - sair");

            input = Integer.parseInt(reader.readLine());

            IMathService mathService = (IMathService) new MathService();

            switch (input) {
                case 1: {
                    System.out.println("Quantos numeros pares ?");
                    int evenQtd = Integer.parseInt(reader.readLine());

                    mathService.evenNumbers(evenQtd);
                }
                case 2: {
                    System.out.println("Multiplo de ?");
                    int mult = Integer.parseInt(reader.readLine());
                    System.out.println("Quantos numeros ?");
                    int qtd = Integer.parseInt(reader.readLine());

                    mathService.multiple(mult,qtd);
                }
                case 3: {
                    System.out.println("Numero para validar ? ");
                    int prime = Integer.parseInt(reader.readLine());

                    mathService.isPrime(prime);
                }
                case 4: {
                    System.out.println("Quantos primos ? ");
                    int qtd = Integer.parseInt(reader.readLine());

                    mathService.primeNumbers(qtd);
                }
                case 5: {
                    System.out.println("numero de naturais?");
                    int nat = Integer.parseInt(reader.readLine());
                    System.out.println("numero especifico ?");
                    int specific = Integer.parseInt(reader.readLine());
                    System.out.println("quantidade ?");
                    int qtd = Integer.parseInt(reader.readLine());

                    mathService.naturalNumberWithSpecificDigits(nat,specific,qtd);
                }
            }
        }while (input != 0);

        System.out.println("Sistema Finalizado");
    }
}
