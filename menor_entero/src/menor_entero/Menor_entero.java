package menor_entero;

import java.util.Scanner;

public class Menor_entero {

    public static void main(String[] args) {
        int n, menor = 1;
        System.out.println("cuantos numeros va introducir");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("numero" + i);
            int k = sc.nextInt();
            if (i == 1) {
                menor = k;
            }

            if (k < menor) {
                menor = k;
            }
        }
        System.out.println("el menor numero es: " + menor);

        //barras problema 16
        int[] y = new int[5];
        
                System.out.println("introduzca 5 numeros del 1 al 30");

        for (int i = 0; i <= 4; i++) {
            int m=i+1;
            System.out.print("numero" + m+": ");
            y[i] = sc.nextInt();
        }
        for (int s = 0; s <= 4; s++) {
            for (int j = 1; j <= y[s]; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

}
