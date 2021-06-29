package Aula3.util;

import Aula3.domain.Precedente;

public class SortUtil{

    public static <T>T[] sort(Precedente<T> arr[]){
        int n = arr.length;
        while (n > 0)
        {
            int lastModifiedIndex = 0;
            for (int currentIndex = 1; currentIndex < n; currentIndex++)
            {
                if (arr[currentIndex - 1].precedeA((T) arr[currentIndex]) > 0)
                {
                    Precedente<T> temp = arr[currentIndex - 1];
                    arr[currentIndex - 1] = arr[currentIndex];
                    arr[currentIndex] = temp;
                    lastModifiedIndex = currentIndex;
                }
            }
            n = lastModifiedIndex;
        }
        System.out.println(arr);
        return (T[]) arr;
    }
}
