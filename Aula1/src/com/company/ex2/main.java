package com.company.ex2;

import com.company.ex2.service.ArrayService;

public class main {
    public static void main(String[] args) {
        Integer[] array = {52,10,85,1324,01,13,62,30,12,127};

        ArrayService service = new ArrayService();

        service.sortArray(array);
    }
}
