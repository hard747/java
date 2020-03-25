package clases;

public class PC extends computadora{
   public PC(double precio_1,double precio_2,double precio_3,double porcentaje,double factor){
        super(precio_1,precio_2,precio_3,factor); 
        this.porcentaje = porcentaje;
    }
    
    public double get_porcentaje_PC(){
    return porcentaje;
    }
   
    private double porcentaje,resultado; 
    
}
