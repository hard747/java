package consola;

import clases.Ordenador;
import clases.Portatiles;
import clases.pcs;
public class PrincipalOrdenador {

   
    public static void main(String[] args) {
      
        Ordenador or = new Ordenador("Ralin PC",1.6,"Windows");
        System.out.println("Datos del Ordenador de Escritorio");
        System.out.println(or.toString());
        System.out.println("-------------------------------------");
        
        //pcs
        pcs pc = new pcs("Nor-Portatil",1.7,"Linux",1340);
        System.out.println("\nDatos del Ordenador de PCs");
        System.out.println(pc.toString());
        System.out.println("Precio Final : " + pc.PrecioPCFinal());
 
        
        pcs pc2 = new pcs("Vistacito",1.7,"Windows",1000);
        System.out.println("\nDatos del Ordenador de PCs");
        System.out.println(pc2.toString());
        System.out.println("Precio Final : " + pc2.PrecioPCFinal());
        
        System.out.println("Precio Final de M pcs : " + pc2.cantidadM(3));
        
        System.out.println("Cantidad de PCs de 1.7 mhz : " +pc2.ventasPCs());



        //portatiles
        Portatiles pt = new Portatiles("Nor-Portatil",1.8,"Linux",5520);
        System.out.println("\nDatos del Ordenador Portatil");
        System.out.println(pt.toString());
        System.out.println("Precio Final : " + pt.PrecioPORTATILFinal());
        System.out.println("Precio Final de N portatiles : " + pt.cantidadN(5));
       
        
        
    }
    
}
