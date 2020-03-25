
package clases;

//import static java.lang.Math.pow;


public class Cooperativa extends Prestamo {

    private double respuesta;//,respuestaII;
    public Cooperativa(String nombres, char tipo, double precio, double interes, int anio) {
        super(nombres, tipo, precio, interes, anio);
    }

    public Cooperativa() {
        
        super("sin nombre",'Y', 2000, 0.1, 3);
    }

    /*@Override
    public String toString() {
       return "Cooperativa{" + "respuesta=" + respuesta + '}';
    }*/

    
    /**
     * @return the respuesta
     */
    public double getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(double respuesta) {
        this.respuesta = respuesta;
    }
    
    
  
   
}
