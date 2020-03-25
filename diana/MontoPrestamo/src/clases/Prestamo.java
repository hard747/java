
package clases;

import static java.lang.Math.pow;

public class Prestamo {
    
    private String nombres;
    private char tipo;
    protected double  precio;
    private double interes;
    protected int año;
    private double respuestaII;
    

    public Prestamo(String nombres, char tipo, double precio, double interes, int año) {
        this.nombres = nombres;
        this.tipo = tipo;
        this.precio = precio;
        this.interes = interes;
        this.año = año;
    }
    
     public Prestamo() {
        this.nombres = "Sin nombre";
        this.tipo = 'm';
        this.precio = 1000;
        this.interes = 0.1;
        this.año = 1;
    }
    
     public double desgravamen(){
         return precio*0.013;
     }
     
     
     
    @Override
    public String toString() {
        return "Prestamo{" + "nombres=" + getNombres() + ", tipo=" + getTipo() + ", precio=" + getPrecio() + ", interes=" + getInteres()*100+"% " + ", a\u00f1o=" + getAnio() + '}';
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the tipo
     */
    public char getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the interes
     */
    public double getInteres() {
        return interes;
    }

    /**
     * @param interes the interes to set
     */
    public void setInteres(double interes) {
        this.interes = interes;
    }

    /**
     * @return the año
     */
    public int getAnio() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAnio(int año) {
        this.año = año;
    }

   /* public String PrecioI(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    
     public double PrecioI() {

        if (getAnio()<=5 && getAnio()>=1) {
            respuestaII =  0.05;

        } else if (getAnio() >= 6) {
            respuestaII = 0.08;

        }
        return respuestaII;
    }
    
    public double monto_inicial(){
    
        return  getPrecio()*getInteres();
    }
    
    public double taza_efectiva(){
        
        return pow(1+PrecioI(),0.083333)-1;
        
     }
    
    public double cuota_mensual(){
    
        return (precio-monto_inicial())*(pow(1+taza_efectiva(),12*año)*taza_efectiva())/(pow(1+taza_efectiva(),12*año)-1);
    }
    
    public double monto_previo(){
    
        return (12*año)*(precio-monto_inicial())*(pow(1+taza_efectiva(),12*año)*taza_efectiva())/(pow(1+taza_efectiva(),12*año)-1);
    }
    public double monto_total(){
    
        return monto_inicial()+monto_previo()+ desgravamen();
    }
    
    public double intereses_total(){
    
        return monto_total()-precio;
    }
    
       
  
}
