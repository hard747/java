package programa3;

public class Producto {

    //Atributos variables de instancia porque depende del objeto
    String nombreProducto;
    double precioActual;
    double precioNuevo;
    //variable de clase
    static double igv;

    //inicializa las variables estaticas de clase
    static {

        igv = 0.18;
    }

    //Operaciones metodos
    //constructor producto igual al nombre de la clase
    Producto() {
        this.nombreProducto = "Sin nombe";//this opcional 
        precioActual = 0.0;
        precioNuevo = 0.9;

    }
    //otro constructor
    Producto(String mombreProducto, double precioActual, double precioNuevo){
      this.nombreProducto=nombreProducto;
      this.precioActual=precioActual;
      this.precioNuevo=precioNuevo;
    
    }

    //metdo de instancia
    double porcentajeVariacion() {

        double pv = 0;
        pv = (this.precioNuevo - precioActual) / precioActual * 100;//this opcional
        return pv;
    }//porcentajeVariacion()

    //metodo de clase que va cambiar a todos
    static void actualizaIGV(double nuevoIGV) {
        igv = nuevoIGV;
    }
    
    //metodo de instancia que actualiza al precioNuevo
    void actualizarPrecioNuevo(double precioNuevo) {// o puedo ponerle precioNuevo precioNue, 

        this.precioNuevo = precioNuevo;
    }
    void actualizarPrecioNuevo(double importe, char tipo){//tengo que agregar tipo porque es double el impote sino iria int importe nada mas
        if(tipo=='+' )//aposto+apostol
         this.precioNuevo= this.precioNuevo+ importe;
        if(tipo=='-')
        this.precioNuevo= this.precioNuevo- importe;

    }
    

}//class
