package Clases;

import static Clases.Ordenadores.garantia;
import static Clases.Ordenadores.igv;

public class Portatiles extends Ordenadores {

    public Portatiles(double precio_1, double precio_2, double precio_3, double factor) {
        super(precio_1, precio_2, precio_3, factor);
    }
    
    public static void actualizarIGV(double nuevoIGV) {

        igv = nuevoIGV;

    }
    
    public static void actualizarGarantia(double nuevoGarantia) {
        garantia = nuevoGarantia;
    }

}
