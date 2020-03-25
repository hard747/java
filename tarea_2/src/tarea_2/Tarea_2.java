package tarea_2;

import java.util.Scanner;

public class Tarea_2 {

    public static void main(String[] args) {
       int cantidad; String tipo,pivote;
       precio n1=new precio();
       Scanner entrada=new Scanner(System.in);
       Scanner datos=new Scanner(System.in);
     
     //compra de PC's  
       System.out.println("\nCuantas PC's de 1.6 Mhz desea comprar :");
       cantidad = datos.nextInt();
       tipo="1.6 Mhz";
       System.out.println("El precio de "+cantidad +" PC's de procesador de "+tipo+" es :"+ n1.precios_pc(tipo,cantidad)+"\n");
       
       System.out.println("Cuantas PC's de 1.7 Mhz desea comprar :");
       cantidad = datos.nextInt();
       tipo="1.7 Mhz";
       System.out.println("El precio de "+cantidad +" PC's de procesador de "+tipo+" es :"+ n1.precios_pc(tipo,cantidad)+"\n");
       
       System.out.println("Cuantas PC's de 1.8 Mhz desea comprar :");
       cantidad = datos.nextInt();
       tipo="1.8 Mhz";
       System.out.println("El precio de "+cantidad +" PC's de procesador de "+tipo+" es :"+ n1.precios_pc(tipo,cantidad)+"\n");
       System.out.println("El importe total de PC's es: "+ n1.importe_total_PC());
       
       //compra de portatiles
       System.out.println("\n\nCuantas portatiles de 1.6 Mhz desea comprar :");
       cantidad = datos.nextInt();
       tipo="1.6 Mhz";
       System.out.println("El precio de "+cantidad +" portatiles de procesador de "+tipo+" es :"+ n1.precios_laptop(tipo,cantidad)+"\n");
       
       System.out.println("Cuantas portatiles de 1.7 Mhz desea comprar :");
       cantidad = datos.nextInt();
       tipo="1.7 Mhz";
       System.out.println("El precio de "+cantidad +" portatiles de procesador de "+tipo+" es :"+ n1.precios_laptop(tipo,cantidad)+"\n");
       
       System.out.println("Cuantas portatiles de 1.8 Mhz desea comprar :");
       cantidad = datos.nextInt();
       tipo="1.8 Mhz";
       System.out.println("El precio de "+cantidad +" portatiles de procesador de "+tipo+" es :"+ n1.precios_laptop(tipo,cantidad)+"\n");     
       System.out.println("El importe total de portatiles es: "+ n1.importe_total_portatiles());
       
      System.out.println("La cantidad de PC's de 1.7 Mhz es : " + n1.cantidad_pc_17());
    }
}
