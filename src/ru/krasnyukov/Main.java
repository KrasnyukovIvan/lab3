package ru.krasnyukov;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[20];
        int numberOfElementInArr = 8;

        arr[0] = -7;
        arr[1] = 7;
        arr[2] = -7;
        arr[3] = 7;
        arr[4] = 1;
        arr[5] = 4;
        arr[6] = 2;
        arr[7] = 1;
        

        System.out.println("Изначальный массив");
        Random random = new Random();
//        for(int i = 0; i < numberOfElementInArr; i++) {
//            arr[i] = random.nextInt(-10, 10);
//            System.out.print(arr[i] + " ");
//        }

        MergeSort(numberOfElementInArr, arr);
        System.out.println("\nСортированный массив");
        for(int i = 0; i < numberOfElementInArr; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nкол-во повторяющщихся элементов " + search(numberOfElementInArr, arr));


        do {
            System.out.println("\nВведите позицию элемента для поиска");
            int pos = in.nextInt();
            System.out.println("Элемент в позиции - " + pos);
            if (pos >= 0 && pos < numberOfElementInArr) {
                System.out.println(arr[pos]);
                break;
            } else {
                System.out.println("Позиция находится вне диапозона массива");
            }
        }while (true);


        System.out.println("\nВведите новый элемент массива");
        arr[numberOfElementInArr++] = in.nextInt();
        MergeSort(numberOfElementInArr, arr);
        System.out.println("\nСортированный массив");
        for(int i = 0; i < numberOfElementInArr; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nкол-во повторяющщихся элементов " + search(numberOfElementInArr, arr));

    }

    public static int search(int n, int[] A) {
        Set<Integer> uniqueValue = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if ((i != j) && (A[i] == A[j])) {
                    uniqueValue.add(A[i]);
                    break;
                }
            }
        }
        return uniqueValue.size();
    }

    public static int[] MergeSort(int n, int[] A) {
        int i, j, k, t, s,  Start1, Fin1, Fin2;
        int[] B = new int[n];

        int numberOfCompare = 0;
        int numberOfReshuffle = 0;

        k = 1;
        while (k < n) {
            t = 0;
            s = 0;
            while (t+k < n) {
                numberOfCompare++;
                Start1 = t;
                Fin1 = t+k;
                if (t+2*k > n) {
                    numberOfCompare++;
                    Fin2 = n;
                } else {
                    Fin2 = t+2*k;
                }
                i = Start1;
                j =Fin1;
                while ((i < Fin1) && (j < Fin2)) {
                    numberOfCompare++;
                    if (A[i] < A[j]) {
                        numberOfReshuffle++;
                        B[s] = A[i];
                        i += 1;
                    } else {
                        numberOfReshuffle++;
                        B[s] = A[j];
                        j += 1;
                    }
                    s += 1;
                }

                while (i < Fin1) {
                    numberOfCompare++;
                    numberOfReshuffle++;
                    B[s] = A[i];
                    i += 1;
                    s += 1;
                }
                while (j < Fin2) {
                    numberOfCompare++;
                    numberOfReshuffle++;
                    B[s] = A[j];
                    j += 1;
                    s += 1;
                }
                t = Fin2;
            }
            k *= 2;
            for  (s = 0; s < t; s++) {
                numberOfCompare++;
                numberOfReshuffle++;
                A[s] = B[s];
            }
        }
        System.out.println("\nСравнений - " + numberOfCompare);
        System.out.println("\nПерестановок - " + numberOfReshuffle);
        return A;
    }
}
