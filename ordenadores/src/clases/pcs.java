package clases;

public class pcs extends Ordenador {
   
    public double PrecioFinal;
    public double M;
    public int vp;
    public pcs(String nombres, double velocidad, String sisoperativo, double PrecioFinal){
        super(nombres,velocidad,sisoperativo);
        this.PrecioFinal=PrecioFinal;
    }
    
     public pcs(){
        super("SIN NOMBRE DEL PORTATTIL",0,"SIN SISTEMA OPERATIVO");
        this.PrecioFinal=0.0;
    }

    public double getPrecioFinal() {
        return PrecioFinal;
    }

    public void setPrecioFinal(double PrecioFinal) {
        this.PrecioFinal = PrecioFinal;
    }

    //@Override
    public String toString() {
        return "pcs{" + "nombres=" + nombres + ", velocidad=" + velocidad + ", sisoperativo=" + sisoperativo  + ", PrecioFinal=" + PrecioFinal + '}';
    }
    
    public double PrecioPC() {
    if(this.velocidad==1.6){
        this.PrecioFinal=1200;
    }
    else if(this.velocidad==1.7){
        this.PrecioFinal=1800;
    }
    else if(this.velocidad==1.8){
        this.PrecioFinal=2140;
    }
    return PrecioFinal;
}
    public double PrecioPCFinal(){
        return 0.19*PrecioFinal+ PrecioFinal;
    }
    
    public double cantidadM(double M){
        return M*PrecioPCFinal();
    }
    
    public double ventasPCs(){
        if(this.velocidad==1.6){
        this.PrecioFinal=1200;
    }
    else if(this.velocidad==1.7){
        this.PrecioFinal=1800;
        vp++;
    }
    else if(this.velocidad==1.8){
        this.PrecioFinal=2140;
    }

        return vp;
    }
}
 
