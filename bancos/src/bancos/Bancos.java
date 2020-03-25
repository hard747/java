
package bancos;
import clases_banco.*;
import java.util.Scanner;

public class Bancos {

   
    public static void main(String[] args) {
        int respuesta;
        entidad_financiera n1= new entidad_financiera(100.00,0.19);
        double m = n1.respuesta;
        System.out.println("quee cantidad desea prestarse: ");
        Scanner entrada=new Scanner(System.in);
        respuesta = entrada.nextInt();
        
        
    }
    
}
