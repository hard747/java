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
public class Triangulo {
    int a;
    int b;
    int c;

    public Triangulo(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public Triangulo() {
        this.a = 1;
        this.b = 1;
        this.c = 1;
    }
    
    double perimetro(){
        return a+b+c;
    }
    
    double area(){
        double sp=perimetro()/2;
        return Math.sqrt(sp*(sp-a)*(sp-b)*(sp-c));
    }
    
    
    
    
}
