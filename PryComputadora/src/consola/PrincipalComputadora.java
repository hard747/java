package consola;

import clases.*;
import java.util.Scanner;

public class PrincipalComputadora {
    
    public static void main(String[] args) {
    int data;
    PC n1=new PC(1200,1800,2140,1.19,1);
    portatil n2=new portatil(1200,1800,2140,1.24,1.7);
    Scanner entrada=new Scanner(System.in);
    //precio PC
    System.out.println("Cuantas PC's de 1.6 Mhz desea comprar :");
    data = entrada.nextInt();
    System.out.println("El precio por unidad de PC's de procesador de 1.6 Mhz es : "+ n1.precios("1.6 Mhz", data)*(n1.get_porcentaje_PC()));
    
    System.out.println("\nCuantas PC's de 1.7 Mhz desea comprar :");
    data = entrada.nextInt();
    System.out.println("El precio por unidad de PC's de procesador de 1.7 Mhz es : "+ n1.precios("1.7 Mhz", data)*(n1.get_porcentaje_PC()));
    
    System.out.println("\nCuantas PC's de 1.8 Mhz desea comprar :");
    data = entrada.nextInt();
    System.out.println("El precio por unidad de PC's de procesador de 1.8 Mhz es : "+ n1.precios("1.8 Mhz", data)*(n1.get_porcentaje_PC()));
    //importe_total
    System.out.println("\nEl importe total de PC's compradas es : "+(n1.importe_total())*n1.get_porcentaje_PC());
    //calculo del igv
    System.out.println("\nEl importe por IGV para las PC's es del "+(n1.get_porcentaje_PC()-1)*100+" % : "+n1.importe_total()*(n1.get_porcentaje_PC()-1));
    
    
    //precio de portatiles
    System.out.println("\n\nCuantas portatiles de 1.6 Mhz desea comprar :");
    data = entrada.nextInt();
    System.out.println("el precio de "+data+" portatiles de 1.6 Mhz es : "+ n2.precios("1.6 Mhz", data)*(n2.get_porcentaje_portatil()));
    
    System.out.println("\nCuantas portatiles  de 1.7 Mhz desea comprar :");
    data = entrada.nextInt();
    System.out.println("el precio de "+data+" portatiles de 1.7 Mhz es : "+ n2.precios("1.7 Mhz", data)*(n2.get_porcentaje_portatil()));
    
    System.out.println("\nCuantas portatiles  de 1.8 Mhz desea comprar :");
    data = entrada.nextInt();
    System.out.println("el precio de "+data+" portatiles de 1.8 Mhz es : "+ n2.precios("1.8 Mhz", data)*(n2.get_porcentaje_portatil()));
    
    //System.out.println("\nEl importe total de portatiles es : "+n2.importe_total());
    System.out.println("\nEl importe total de PC's es : "+(n2.importe_total())*n2.get_porcentaje_portatil());
    //calculo del igv portatiles
    System.out.println("\nEl importe por IGV mas el de garantia para las PC's es del "+((n2.get_porcentaje_portatil())/(1.7)-1)*100+" % : "+n2.importe_total()*((n2.get_porcentaje_portatil())/(1.7)-1));
  
    //cantidad de PC's de 1.7 Mhz
    System.out.println("La cantidad de PC's de 1.7 Mhz es : "+ n1.cantidad());
   System.out.println(n2.get_porcentaje_portatil());
    }
    
}
