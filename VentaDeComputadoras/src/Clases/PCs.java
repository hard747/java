package Clases;

import static Clases.Ordenadores.igv;

public class PCs extends Ordenadores {

    public PCs(double precio_1, double precio_2, double precio_3, double factor) {
        super(precio_1, precio_2, precio_3, factor);
    }

    public static void actualizarIGV(double nueva_igv) {

        igv = nueva_igv;

    }
    
}
