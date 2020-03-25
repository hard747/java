package clases;

public class Portatiles extends Ordenador {
    
    private double PrecioFinalP;
     private double N;
    
    public Portatiles(String nombres, double velocidad, String sisoperativo, double PrecioFinal){
        super(nombres,velocidad,sisoperativo);
        this.PrecioFinalP=1.7*PrecioFinal;
    }
    public Portatiles(){
        super("SIN NOMBRE DEL PORTATTIL",0,"SIN SISTEMA OPERATIVO" );
        this.PrecioFinalP=0.0;
    }

    public double getPrecioFinal() {
        return PrecioFinalP;
    }

    public void setPrecioFinal(double PrecioFinal) {
        this.PrecioFinalP = 1.7*PrecioFinal;
    }

   // @Override
    public String toString() {
        return "Portatiles{" + "nombres=" + nombres + ", velocidad=" + velocidad + ", sisoperativo=" + sisoperativo  + ", PrecioFinal=" + PrecioFinalP + '}';
    }
    
    
    public double PrecioPORTATIL() {
    if(this.velocidad==1.6){
        this.PrecioFinalP=1.7*1200;
    }
    else if(this.velocidad==1.7){
        this.PrecioFinalP=1.7*1800;
    }
    else if(this.velocidad==1.8){
        this.PrecioFinalP=1.7*2140;
    }
    return PrecioFinalP;
}
    public double PrecioPORTATILFinal(){
        return 0.19*PrecioFinalP+ 0.05*PrecioFinalP+PrecioFinalP;
    } 

    public double cantidadN(double N){
        return N*PrecioPORTATILFinal();
    } 
    
}
