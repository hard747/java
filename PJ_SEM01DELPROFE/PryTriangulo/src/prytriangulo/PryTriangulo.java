/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prytriangulo;

/**
 *
 * @author HugoVM
 */
public class PryTriangulo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Triangulo t1, t2;
        t1 = new Triangulo();
        System.out.println("Perimetro: " + t1.perimetro());
        System.out.println("area: " + t1.area());
        
        t2 = new Triangulo(3,4,5);
        System.out.println("Perimetro: " + t2.perimetro());
        System.out.println("area: " + t2.area());
        
    }
    
}
