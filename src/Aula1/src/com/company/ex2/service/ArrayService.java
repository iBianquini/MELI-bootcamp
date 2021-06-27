package Aula1.src.com.company.ex2.service;


import Aula1.src.com.company.ex2.service.interfaces.IArrayService;

import java.util.Arrays;
import java.util.Collections;

public class ArrayService implements IArrayService {
    @Override
    public void sortArray(Integer[] array) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println(Arrays.toString(array));
    }
}
