/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema24;

public class recursividad {

    long factorial(int n) {

        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }

    }

     long factor(int n) {

        if (n == 1) {
            return 1;
        } else 
        {
            return n * factor(n - 2);
        }
        

    }
}
