package ru.krasnyukov;


public class Sort {
    public static int[] MergeSort(int n, int[] A) {
        int i, j, k, t, s,  Start1, Fin1, Fin2;
        int[] B = new int[n];

        k = 1;
        while (k < n) {
            t = 0;
            s = 0;
            while (t+k < n) {
                Start1 = t;
                Fin1 = t+k;
                if (t+2*k > n) {
                    Fin2 = n;
                } else {
                    Fin2 = t+2*k;
                }
                i = Start1;
                j =Fin1;
                while ((i < Fin1) && (j < Fin2)) {
                    if (A[i] < A[j]) {
                        B[s] = A[i];
                        i += 1;
                    } else {
                        B[s] = A[j];
                        j += 1;
                    }
                    s += 1;
                }

                while (i < Fin1) {
                    B[s] = A[i];
                    i += 1;
                    s += 1;
                }
                while (j < Fin2) {
                    B[s] = A[j];
                    j += 1;
                    s += 1;
                }
                t = Fin2;
            }
            k *= 2;
            for  (s = 0; s < t; s++) {
                A[s] = B[s];
            }
        }
        return A;
    }
}
