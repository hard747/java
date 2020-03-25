
package clases;


public class Banco extends Prestamo {
    private double respuesta,respuestaI;
    //double respuesta1, respuesta2, respuesta3 ;

    public Banco(String nombres, char tipo, double precio, double interes, int año) {
        super(nombres, tipo, precio, interes, año);
    }

    public Banco( ) {
        
        super("sin nombre",'Y', 1000, 0.2, 1);
        
     
    }
    

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
