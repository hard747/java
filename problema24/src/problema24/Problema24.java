package problema24;

import java.util.Scanner;

public class Problema24 {

    public static void main(String[] args) {
        int m, n;
        System.out.println("Introduzca un numero impar entre el rango del 1 al 19 que sera el numero de filas del rombo");
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = (m + 1) / 2;
        for (int i = 1; i <= n; i++) {
            System.out.println();

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");

            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
        }
        //segunda parte
        for (int i = 1; i <= n - 1; i++) {
            System.out.println();

            for (int j = 1; j <= i; j++) {
                System.out.print(" ");

            }
            for (int j = 1; j <= 2 * n - 1 - 2 * i; j++) {
                System.out.print("*");
            }
        }
        System.out.println();

//problema 13 factorial        
        long resul;
        recursividad prueba = new recursividad();
        for (int i = 1; i <= 20; i++) {
            resul = prueba.factorial(i);
            System.out.println(resul + "\t");
        }
//problema 10 y 27
        //for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k <= 5; k++) {
                    System.out.print("@");
                }
                System.out.println();

            }
          //  System.out.println();
        //}
//problema 12
long res;int i=1;
        //recursividad prueba = new recursividad();
       
            res = prueba.factor(15);
            System.out.println(res);
        
    }

}
