package Aula1.src.com.company.ex1.service;


import Aula1.src.com.company.ex1.service.Interface.IMathService;

import java.util.ArrayList;
import java.util.List;

public class MathService implements IMathService {
    @Override
    public void evenNumbers(int qtd) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (int i = 0; evenNumbers.size() < qtd; i++) {
            if (i % 2 == 0)
                evenNumbers.add(i);
        }
        System.out.println("Números pares: " + evenNumbers);
    }

    @Override
    public void multiple(int mult, int qtd) {
        List<Integer> multiples = new ArrayList<>();

        for (int i = 0; multiples.size() < qtd; i++) {
            if (i % mult == 0)
                multiples.add(i);
        }
        System.out.println("Números pares: " + multiples);
    }

    public void isPrime(int number){
        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                System.out.println("Não é primo");
                return;
            }
        }
        System.out.println("É primo");
    }

    @Override
    public void primeNumbers(int qtd) {
        List<Integer> primes = new ArrayList<>();
        boolean isPrime;
        for (int i = 2; primes.size() < qtd; i++) {
            isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    isPrime = false;
            }
            if (isPrime)
                primes.add(i);
        }
        if (primes.isEmpty())
            System.out.println("Não há primos");
        System.out.println("Primos: " + primes);
    }

    @Override
    public void naturalNumberWithSpecificDigits(int naturalQtd, int specificNumber, int qtdSpecificDigit) {
        List<Integer> naturalNumbers = new ArrayList<>();
        int count;
        char[] currentNumber;

        for (int i = 0; naturalNumbers.size() < naturalQtd; i++) {
            currentNumber = String.valueOf(i).toCharArray();

            if (currentNumber.length < qtdSpecificDigit)
                continue;

            count = 0;

            for (int j = 0; j < currentNumber.length; j++) {
                if (String.valueOf(currentNumber[j]).equals(String.valueOf(specificNumber)))
                    count++;
            }

            if(count == qtdSpecificDigit)
                naturalNumbers.add(i);
        }

        System.out.println("Numeros naturais: " + naturalNumbers);
    }


}
