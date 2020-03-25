package consola;

public class Producto {

    //atributos: variables
    String nombreProducto;
    double precioActual;
    double precioNuevo;
    static double igv;
    
    static {
        igv=0.18;
    }

    //operaciones: metodos
    
    Producto(){
        this.nombreProducto="SIN NOMBRE";
        precioActual=0.0;
        precioNuevo=9.9;
    }
    
    Producto(String nombreProducto, double precioActual, double precioNuevo){
        this.nombreProducto=nombreProducto;
        this.precioActual=precioActual;
        this.precioNuevo=precioNuevo;
    }
    
    double porcentajeVariacion() {
        double pv = 0;
        pv = (this.precioNuevo - precioActual) / precioActual * 100;
        return pv;
    }//porcentajeVariacion(
    
    static void actualizaIGV(double nuevoIGV){
        igv = nuevoIGV;
    }
    
    void actualizaPrecioNuevo(double precioNuevo){
        this.precioNuevo=precioNuevo;
    }
    
    void actualizaPrecioNuevo(double importe, char tipo){
        if (tipo=='+')
        this.precioNuevo = this.precioNuevo + importe;
        if (tipo=='-')
        this.precioNuevo = this.precioNuevo - importe;
    }

}//class
