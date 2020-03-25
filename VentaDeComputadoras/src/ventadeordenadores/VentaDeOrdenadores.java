package ventadeordenadores;

import Clases.*;

public class VentaDeOrdenadores {

    public static void main(String[] args) {
        
        //metodos_para_actualizar_igv_garantia
        PCs.actualizarIGV(0.19);
        Portatiles.actualizarGarantia(0.05);

        //creacion de objetos de clase PCs y portatil    
        PCs obj1 = new PCs(1200, 1800, 2140, 1);
        Portatiles obj2 = new Portatiles(1200, 1800, 2140, 1.7);
       
       
       //PCs
        System.out.print("\nVenta de ordenadores PCs");
        obj1.Proceso();
        //calculo de cantidad de PCs de 1.7 Mhz
        System.out.println("\nla cantidad de PC's de 1.7 Mhz es: "+ obj1.cantidad());
         //calculos y ventas de PCs
        System.out.println("\nEl precio final de "+ obj1.cantidad_total() +" PCs es:  " + obj1.calculo_subtotal());//subtotal: suma de :(precios unitarios x cantidad)
        System.out.println("El igv es del "+PCs.igv*100+" % : "+ obj1.calculo_igv(PCs.igv));
        System.out.println("El importe total de " + obj1.cantidad_total() + " PC's es: " + obj1.precio_final(PCs.igv, 0));

        
        //calculos y ventas de portatiles
        System.out.print("\n\nVenta de ordenadores Portatiles");
        obj2.Proceso();
        System.out.println("\nEl precio final de "+obj2.cantidad_total()+" portatiles es:  " + obj2.calculo_subtotal());//subtotal
        System.out.println("El igv es del "+Portatiles.igv*100+" % : "+ obj2.calculo_igv(PCs.igv));//igv
        System.out.println("La garantia es del "+Portatiles.garantia*100+" % : "+ obj2.calculo_garantia(Portatiles.garantia));//garantia
        System.out.println("el importe total de "+obj2.cantidad_total()+" portatiles es :" + obj2.precio_final(Portatiles.igv, Portatiles.garantia));//precio final
        
        System.out.println("\nel importe total de "+obj1.cantidad_total()+" PCs y " + obj2.cantidad_total()+" portatiles es :"+ (obj1.precio_final(PCs.igv, 0)+obj2.precio_final(Portatiles.igv, Portatiles.garantia)));

    }

}
