
package clases_banco;

public class entidad_financiera {
    public double respuesta,porcentaje;
    
    public entidad_financiera(double respuesta,double porcentaje){
    
        this.respuesta=respuesta;
        this.porcentaje=porcentaje;
    
    }

     public double cuota_inicial(double respuesta,double porcentaje){
         
         return respuesta*porcentaje;
    
    }
}

 


 