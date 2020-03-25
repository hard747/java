
package programa4;


public class Programa4 {

  
    public static void main(String[] args) {
        
        Triangulo tri1, tri2 ;
        
        tri1=new Triangulo();
        System.out.println("Datos del primer triangulo");
        tri1.lado1=2;
        tri1.lado2=3;
        tri1.lado3=4;
        
        System.out.println("el perimetro del triangulo es: "+ tri1.perimetro);
        
         tri2=new Triangulo();
        System.out.println("Datos del primer triangulo");
        tri2.lado1=8;
        tri2.lado2=6;
        tri2.lado3=2;
        
        System.out.println("el perimetro del triangulo es: "+ tri2.perimetro);
        
        
        
        
        
    }
    
}
