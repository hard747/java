package mcm;

import java.util.Scanner;

public class Mcm {

    public static void main(String[] args) {
        int x, y;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el primer numero");
        x = sc.nextInt();
        System.out.println("Introduzca el segundo numero");
        y = sc.nextInt();

        int i = 2;
        if (x < y) {
            int r=x;
            while (r % y != 0) {
                r = x * i;
                i++;
            }
            System.out.println("El minimo comun multiplo de "+x+" y "+y+" es igual a " + r);
        } else if (y < x) {
            int m=y;
            while (m % x != 0) {
                m = y * i;
                i++;
            }

            System.out.println("El minimo comun multiplo de "+x+" y "+y+" es igual a " + m);
        } else {
            System.out.println("El minimo comun multiplo es igual a " + x);

        }//este es un comentario para git
    }
}
