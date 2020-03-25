package consola;

public class PrincipalVariacionOO {

    public static void main(String[] args) {
        Producto.actualizaIGV(0.2);
        Producto prod1, prod2;
        prod1 = new Producto();
        System.out.println("Datos iniciales del producto");
        System.out.println("Nombre del producto: " + prod1.nombreProducto);
        System.out.println("Precio actual: " + prod1.precioActual);
        System.out.println("Precio nuevo: " + prod1.precioNuevo);
        System.out.println("IGV: " + Producto.igv);
        
        System.out.println("\nDatos actualizados del producto");        
        prod1.nombreProducto="Computador";
        prod1.precioActual=2000;
        prod1.precioNuevo=2400;
        System.out.println("Nombre del producto: " + prod1.nombreProducto);
        System.out.println("Precio actual: " + prod1.precioActual);
        System.out.println("Precio nuevo: " + prod1.precioNuevo);
        System.out.println("IGV: " + Producto.igv);
        
        double pv=prod1.porcentajeVariacion();
        System.out.println("% variacion: " + pv);
        
        
        prod2 = new Producto();
        prod2.nombreProducto="Impresora";
        prod2.precioActual=1000;
        prod2.precioNuevo=1400;
        System.out.println("\nNombre del producto 2: " + prod2.nombreProducto);
        System.out.println("Precio actual 2: " + prod2.precioActual);
        System.out.println("Precio nuevo 2: " + prod2.precioNuevo);
        System.out.println("IGV: " + Producto.igv);
        
        pv=prod2.porcentajeVariacion();
        System.out.println("% variacion: " + pv);
        
        
        //prueba de metodo de clase
        Producto.actualizaIGV(0.2);
        System.out.println("\nIGV de prod1: " + prod2.igv);
        
        //prueba this
        System.out.println("\nPrecio nuevo de prod2: " + prod2.precioNuevo);
        prod2.actualizaPrecioNuevo(500,'-');
        System.out.println("Precio actualizado de prod2: " + prod2.precioNuevo);
        
        //sobrecarga de constructores
        Producto prod3;
        prod3 = new Producto("Meza", 100, 120);
        System.out.println("\nDatos iniciales de prod3");
        System.out.println("Nombre del producto: " + prod3.nombreProducto);
        System.out.println("Precio actual: " + prod3.precioActual);
        System.out.println("Precio nuevo: " + prod3.precioNuevo);
        System.out.println("IGV: " + Producto.igv);

    }//main()
    
}//class
