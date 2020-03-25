package programa2;

public class Programa2 {
    
    static double porcentaje(double precActual, double precNuevo){
        
        double pv=0;
      pv=  (precNuevo - precActual) / precActual * 100;
      return pv;
    
    }//porcentaje()

    public static void main(String[] args) {

        //declaracion de avriables
        String nombreProducto;
        double precioActual;
        double precioNuevo;
        double porcentajeVariacion;

        //inicializar las variables de entrada
        nombreProducto = "Computador";
        precioActual = 2000;
        precioNuevo = 2400;

        //proceso
        porcentajeVariacion = porcentaje(precioActual, precioNuevo);

        //mostrar los resultados
        System.out.println("% variacion " + porcentajeVariacion);
    }//main(

}//class
