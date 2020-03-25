package consola;

public class PrincipalVariacionEstructurada {

    static double porcentajeVariacion(double precAct, double precNuev) {
        double pv = 0;
        pv = (precNuev - precAct) / precAct * 100;
        return pv;
    }//porcentajeVariacion()

    public static void main(String[] args) {
        //declaracion de variables
        String nombreProducto;
        double precioActual;
        double precioNuevo;
        double porcVariacion;
        //inicializar las variables de entrada
        nombreProducto = "Computador";
        precioActual = 2200;
        precioNuevo = 2400;
        //proceso
        porcVariacion = porcentajeVariacion(precioActual,precioNuevo);
        //mostrar los resultados
        System.out.println("% variacion: " + porcVariacion);
    }//main()

}//class
