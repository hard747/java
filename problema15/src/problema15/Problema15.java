/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema15;

/**
 *
 * @author CYBERPOOL
 */
public class Problema15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //primer triangulo
        for (int j = 1; j <= 10; j++) {
            System.out.println();
            for (int i = 1; i <= j; i++) {

                System.out.print("*");
            }
        }
        //System.out.println();

        //segundo triangulo
        for (int j = 10; j >= 1; j--) {
            System.out.println();
            for (int i = 1; i <= j; i++) {

                System.out.print("*");
            }
        }

        //System.out.println();
        //tercer triangulo   
        for (int j = 10; j >= 1; j--) {
            System.out.println();
            for (int k = 10; k > j; k--) {
                System.out.print(' ');
            }

            for (int i = 1; i <= j; i++) {

                System.out.print("*");
            }
        }

        //System.out.println();

        //cuarto triangulo   
        for (int j = 1; j <= 10; j++) {
            System.out.println();
            for (int k = 10; k >j; k--) {
                System.out.print(' ');
            }
            for (int i = 0; i <j; i++) {
                System.out.print("*");

            }

            
        }

        System.out.println();
    }

}
