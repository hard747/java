
package prytriangulo;


public class PryTriangulo {

   
    public static void main(String[] args) {
        // TODO code application logic here
        Triangulo t1, t2;
        t1 = new Triangulo();
        t1.perimetro();
        t1.area();
        t1.verdad();
        
        t2 = new Triangulo(7,5,1);
 
        t2.perimetro();
        t2.area();
        t2.verdad();
        
        
    }
    
}
