
package consola;

import clases.Banco;
import clases.Cooperativa;
//import clases.Prestamo;

public class MontoPrestamo {

   
    public static void main(String[] args) {
        
        
        /*Prestamo m =new Prestamo("BCP",'B', 1000, 0.1, 4);
        System.out.println("Datos de la persona");
        System.out.println(m.toString());
        System.out.println("Porcentaje de interes inicial es :  " + m.getInteres());
        System.out.println("Monto inicial es: " + m.getPrecio()*m.getInteres());*/
        
        
        
        Banco n =new Banco("Interbanc",'B', 2000, 0.10, 3); 
        System.out.println("\nDatos de la persona");
        System.out.println(n.toString());
        System.out.println("Porcentaje de cuota inicial es :  " + n.getInteres()*100+" % ");
        System.out.println("La cuota inicial es: " + n.monto_inicial());
        System.out.println("La taza de interes nominal es: " + n.PrecioI()*100+" % ");
        System.out.println("El costo por desgravamen es: "+n.desgravamen());
        System.out.println("La cuota mensual es: "+ n.cuota_mensual());
        System.out.println("Total intereses: "+ n.intereses_total());
        System.out.println("El monto total es: "+ n.monto_total());
        
        Cooperativa v =new Cooperativa("Credito",'C', 3000, 0.12, 4);
        System.out.println("\nDatos de la persona");
        System.out.println(v.toString());
        System.out.println("Porcentaje de cuota inicial es :  " + v.getInteres()*100+" % ");
        System.out.println("La cuota inicial es: " + v.monto_inicial());
        System.out.println("La taza de interes nominal es: " + v.PrecioI()*100+" % ");
        System.out.println("El costo por desgravamen es: "+v.desgravamen());
        System.out.println("La cuota mensual es: "+ v.cuota_mensual());
        System.out.println("Total intereses: "+ v.intereses_total());
        System.out.println("El monto total es: "+ v.monto_total());
        
    }
    
}
