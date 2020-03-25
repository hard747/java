package clases;

public class portatil extends computadora {
    
    public portatil(double precio_1,double precio_2,double precio_3,double porcentaje,double factor){
        super(precio_1,precio_2,precio_3,factor); 
        this.porcentaje = porcentaje;
    }
    
    public double get_porcentaje_portatil(){
    return porcentaje;
    }
    
    private double porcentaje,resultado;
}
